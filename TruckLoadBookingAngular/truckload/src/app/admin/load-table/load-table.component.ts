import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-load-table',
  templateUrl: './load-table.component.html',
  styleUrls: ['./load-table.component.css']
})
export class LoadTableComponent implements OnInit {

  truckLoadDetails!:Truckload[];
  displayedColumns: string[] = ['Load ID', 'Pickup Date', 'Pickup Location', 'Drop Date', 'Drop Location','Item type', 'Driver ID', 'Booking Status','Operations'];
  constructor(@Inject(MAT_DIALOG_DATA) public data:any) { 
    this.truckLoadDetails=data;
  }

  ngOnInit(): void {
  }

}
