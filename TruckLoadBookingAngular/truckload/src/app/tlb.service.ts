import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Truckload } from './truckload';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class TlbService {

  private userUrl="http://localhost:8090/api/v1/tlb";
  private truckloadUrl="http://localhost:8091/api/v1/tlb";
 url!:any;
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
    let resp=this._http.post(`${this.truckloadUrl}/createLoad`,load,{responseType: 'text' as 'json'});
    return resp;
  }

  public searchLoadForAdmin(load:Truckload){
    if(load.loadId!=null && load.pickupDate==null && load.pickupLocation==null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}`;
		}else if(load.loadId==null && load.pickupDate!=null && load.pickupLocation==null) {
			this.url=`${this.truckloadUrl}/search?&pickupDate=${load.pickupDate}`;
		}else if(load.loadId==null && load.pickupDate==null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && load.pickupDate!=null && load.pickupLocation==null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupDate=${load.pickupDate}`;
		}else if(load.loadId!=null && load.pickupDate==null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId==null && load.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?pickupDate=${load.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}else if(load.loadId!=null && load.pickupDate!=null && load.pickupLocation!=null) {
			this.url=`${this.truckloadUrl}/search?loadId=${load.loadId}&pickupDate=${load.pickupDate}&pickupLocation=${load.pickupLocation}`;
		}
    console.log(this.url)
    return this._http.get<any>(this.url);

  }
}
