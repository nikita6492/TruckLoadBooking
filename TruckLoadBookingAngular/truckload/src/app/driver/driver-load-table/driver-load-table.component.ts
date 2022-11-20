import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-driver-load-table',
  templateUrl: './driver-load-table.component.html',
  styleUrls: ['./driver-load-table.component.css']
})
export class DriverLoadTableComponent implements OnInit {
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

  book(loadId:number){
    for (let i = 0; i < this.truckLoadDetails.length; i++) {
      if (this.truckLoadDetails[i].loadId === loadId) {
        this.truckLoadDetails.splice(i,1);
        this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
        this.tlbservice.bookLoad(loadId).subscribe(
          data => {
            console.log(data);
            this.truckLoadDetails.splice(i,1);
        this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
            this.snackbar.open("Truck Load Booked !!")
            
          },error=>{
            console.log(error);
            this.snackbar.open("Something went wrong !!")
          }
        );
      }
    }

  }

}
