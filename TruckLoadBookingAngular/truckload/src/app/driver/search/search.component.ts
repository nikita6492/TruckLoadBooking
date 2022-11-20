import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';
import { DriverLoadTableComponent } from '../driver-load-table/driver-load-table.component';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchForm!:FormGroup;
  truckLoad=new Truckload();
  truckLoadDetails!:Truckload[];
  showLoadDetails: boolean = false;
  constructor(private service:TlbService,private formBuilder:FormBuilder, private snackbar:MatSnackBar, private route:Router,private dialogref:MatDialog) { }

  ngOnInit(): void {

    
    this.searchForm=this.formBuilder.group({
      pickupDate: ['', Validators.required],
      pickupLocation: ['', Validators.required],
      loadId: ['', [Validators.required]],
      
    });
  }
  search(){
    this.truckLoad.loadId=this.searchForm.controls['loadId'].value;
    this.truckLoad.pickupDate=this.searchForm.controls['pickupDate'].value;
    this.truckLoad.pickupLocation=this.searchForm.controls['pickupLocation'].value;
    this.service.searchLoadForDriver(this.truckLoad).subscribe(
      data=>{
        this.showLoadDetails=true;
        this.truckLoadDetails=data;
        console.log(this.truckLoadDetails);
        this.dialogref.open(DriverLoadTableComponent,{
          data:this.truckLoadDetails
        })
      }
    );
  }
}
