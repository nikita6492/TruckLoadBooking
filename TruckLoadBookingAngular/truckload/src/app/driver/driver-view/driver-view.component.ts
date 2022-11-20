import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-driver-view',
  templateUrl: './driver-view.component.html',
  styleUrls: ['./driver-view.component.css']
})
export class DriverViewComponent implements OnInit {

  truckLoadDetails!:Truckload[];
  displayedColumns: string[] = ['loadId', 'pickupDate', 'pickupLocation', 'dropDate', 'dropLocation','itemType', 'driverId', 'bookingStatus','Operations'];
  showCancelButton:Boolean=false;
  truckLoadDataSource!:any;
  constructor(@Inject(MAT_DIALOG_DATA) public data:any, private tlbservice:TlbService,private snackbar:MatSnackBar) { 
    this.truckLoadDetails=data;
    this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
  }
  ngOnInit(): void {
  }
  intransit(loadId:number){
    for (let i = 0; i < this.truckLoadDetails.length; i++) {
      if (this.truckLoadDetails[i].loadId === loadId) {
        
        this.tlbservice.intransitLoad(loadId).subscribe(
          data => {
            console.log(data);
            this.truckLoadDetails.splice(i,1);
        this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
            this.snackbar.open("Truck Load is in InTransit !!")
            
          },error=>{
            console.log(error);
            this.snackbar.open("Something went wrong !!")
          }
        );
      }
    }

  }

  completeLoad(loadId:number){
    for (let i = 0; i < this.truckLoadDetails.length; i++) {
      if (this.truckLoadDetails[i].loadId === loadId) {
        
        this.tlbservice.completeLoad(loadId).subscribe(
          data => {
            console.log(data);
            this.truckLoadDetails.splice(i,1);
        this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
            this.snackbar.open("Truck Load is Completed !!")
            
          },error=>{
            console.log(error);
            this.snackbar.open("Something went wrong !!")
          }
        );
      }
    }

  }
}
