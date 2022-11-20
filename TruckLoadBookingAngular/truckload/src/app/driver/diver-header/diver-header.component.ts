import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ViewComponent } from 'src/app/admin/view/view.component';
import { TlbService } from 'src/app/tlb.service';
import { DriverViewComponent } from '../driver-view/driver-view.component';
import { SearchComponent } from '../search/search.component';

@Component({
  selector: 'app-diver-header',
  templateUrl: './diver-header.component.html',
  styleUrls: ['./diver-header.component.css']
})
export class DiverHeaderComponent implements OnInit {

  truckLoadDetails!:any;
  constructor(private route:Router,private dialog:MatDialog, private tlbservice: TlbService) { }

  ngOnInit(): void {
  }

  logout(){
    sessionStorage.clear();
    this.route.navigate(['/logout']);

  }
  search(){
    const dialoagRef = this.dialog.open(SearchComponent);
  }

  viewAllBookedLoads(){
    this.tlbservice.viewBookedLoad().subscribe(
      data=>{
        this.truckLoadDetails=data;
        this.dialog.open(DriverViewComponent,{
          data:this.truckLoadDetails
        })
      }
    )
  }

  viewAllIntransitLoads(){
    this.tlbservice.viewIntransitLoad().subscribe(
      data=>{
        this.truckLoadDetails=data;
        this.dialog.open(DriverViewComponent,{
          data:this.truckLoadDetails
        })
      }
    )
  }

  viewAllCompletedLoads(){
    this.tlbservice.viewCompletedLoad().subscribe(
      data=>{
        this.truckLoadDetails=data;
        this.dialog.open(ViewComponent,{
          data:this.truckLoadDetails
        })
      }
    )
  }
}
