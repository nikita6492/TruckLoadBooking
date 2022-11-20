import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  truckLoadDetails!:Truckload[];
  displayedColumns: string[] = ['loadId', 'pickupDate', 'pickupLocation', 'dropDate', 'dropLocation','itemType', 'driverId', 'bookingStatus'];
  showCancelButton:Boolean=false;
  truckLoadDataSource!:any;
  constructor(@Inject(MAT_DIALOG_DATA) public data:any) { 
    this.truckLoadDetails=data;
    this.truckLoadDataSource = new MatTableDataSource(this.truckLoadDetails);
  }

  ngOnInit(): void {
  }

}
