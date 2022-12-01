import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Truckload } from './truckload';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class TlbService {

  private userUrl="http://ec2-43-206-111-226.ap-northeast-1.compute.amazonaws.com:8090/api/v1/tlb";
  private truckloadUrl="http://ec2-35-76-112-141.ap-northeast-1.compute.amazonaws.com:8091/api/v1/tlb";
 url!:any;
 pickupDate!:string;
  constructor(private _http:HttpClient) { }

  public login(user:User){
  let resp= this._http.post(`${this.userUrl}/login`,user,{responseType: 'text' as 'json'});
  return resp;
  }

  public register(user:User){
    let resp=this._http.post(`${this.userUrl}/register`,user,{responseType: 'text' as 'json'});
    return resp;
  }

  public getCountries(){
    let resp=this._http.get(`${this.userUrl}/getCountries`);
    return resp;
  }

  public getStates(country:any){
    let resp=this._http.get(`${this.userUrl}/getStates/`+country);
    return resp;
  }

  public getCities(state:any){
    let resp=this._http.get(`${this.userUrl}/getCities/`+state);
    return resp;
  }

  public createLoad(load:Truckload){
    console.log(load);
    let resp=this._http.post(`${this.truckloadUrl}/createLoad`,load,{responseType: 'text' as 'json'});
    return resp;
  }

  public searchLoadForAdmin(load:Truckload){
    if(load.pickupDate!=null && load.pickupDate){
    let date = new Date(load.pickupDate);
     let mnth = ("0" + (date.getMonth() + 1)).slice(-2);
     let day = ("0" + date.getDate()).slice(-2);
   this.pickupDate = [date.getFullYear(), mnth, day].join("-");
  }
    if(load.loadId!=null && (this.pickupDate==null) && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}`;
		}else if((load.loadId==null || !load.loadId) && this.pickupDate!=null && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search?pickupDate=${this.pickupDate}`;
		}else if((load.loadId==null || !load.loadId) && (this.pickupDate==null) && (load.pickupLocation!=null)) {
			this.url=`${this.truckloadUrl}/search?pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && this.pickupDate!=null && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupDate=${this.pickupDate}`;
		}else if(load.loadId!=null && (this.pickupDate==null ) && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupLocation=${load.pickupLocation}`;
		}else if((load.loadId==null || !load.loadId) && this.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?pickupDate=${this.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && this.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupDate=${this.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}
    console.log(this.url)
    return this._http.get<any>(this.url);

  }

  public cancelLoad(loadId:number){
    let resp=this._http.post(`${this.truckloadUrl}/cancelLoad/${loadId}`,{responseType: 'text' as 'json'});
    return resp;
  }

  public viewLoad(){
    let resp = this._http.get(`${this.truckloadUrl}/viewAllLoads`);
    return resp;
  }

  public bookLoad(loadId:number){
    let user_email = sessionStorage.getItem("user_email");
    let resp=this._http.post(`${this.truckloadUrl}/bookLoad/${loadId}?email=${user_email}`,{responseType: 'text' as 'json'});
    return resp;
  }

  public intransitLoad(loadId:number){
    let user_email = sessionStorage.getItem("user_email");
    let resp=this._http.post(`${this.truckloadUrl}/intransitLoad/${loadId}?email=${user_email}`,{responseType: 'text' as 'json'});
    return resp;
  }

  public completeLoad(loadId:number){
    let user_email = sessionStorage.getItem("user_email");
    let resp=this._http.post(`${this.truckloadUrl}/completeLoad/${loadId}?email=${user_email}`,{responseType: 'text' as 'json'});
    return resp;
  }

  public viewBookedLoad(){
    let user_email = sessionStorage.getItem("user_email");
    let resp = this._http.get(`${this.truckloadUrl}/viewBookedLoads?email=${user_email}`);
    return resp;
  }

  public viewIntransitLoad(){
    let user_email = sessionStorage.getItem("user_email");
    let resp = this._http.get(`${this.truckloadUrl}/viewInTransitLoads?email=${user_email}`);
    return resp;
  }

  public viewCompletedLoad(){
    let user_email = sessionStorage.getItem("user_email");
    let resp = this._http.get(`${this.truckloadUrl}/viewCompletedLoads?email=${user_email}`);
    return resp;
  }

  public searchLoadForDriver(load:Truckload){
    
    if(load.pickupDate!=null && load.pickupDate){
      console.log("*");
    let date = new Date(load.pickupDate);
     let mnth = ("0" + (date.getMonth() + 1)).slice(-2);
     let day = ("0" + date.getDate()).slice(-2);
   this.pickupDate= [date.getFullYear(), mnth, day].join("-");
    }
    if(load.loadId!=null && (this.pickupDate==null) && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search/driver?loadId=${load.loadId}`;
		}else if((load.loadId==null || !load.loadId) && this.pickupDate!=null && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search/driver?pickupDate=${this.pickupDate}`;
		}else if((load.loadId==null || !load.loadId) && (this.pickupDate==null) && (load.pickupLocation!=null)) {
			this.url=`${this.truckloadUrl}/search/driver?pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && load.pickupDate!=null && (load.pickupLocation==null || !load.pickupLocation)) {
			this.url=`${this.truckloadUrl}/search/driver?loadId=${load.loadId}&pickupDate=${this.pickupDate}`;
		}else if(load.loadId!=null && (this.pickupDate==null) && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search/driver?loadId=${load.loadId}&pickupLocation=${load.pickupLocation}`;
		}else if((load.loadId==null || !load.loadId) && this.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search/driver?pickupDate=${this.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && this.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search/driver?loadId=${load.loadId}&pickupDate=${this.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}
    console.log(this.url)
    return this._http.get<any>(this.url);

  }
}
