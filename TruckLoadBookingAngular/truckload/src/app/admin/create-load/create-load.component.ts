import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-create-load',
  templateUrl: './create-load.component.html',
  styleUrls: ['./create-load.component.css']
})
export class CreateLoadComponent implements OnInit {
loadForm!:FormGroup;
  minDate=new Date();
  truckLoad=new Truckload();
  constructor(private service:TlbService,private formBuilder:FormBuilder, private snackbar:MatSnackBar, private route:Router) { }

  ngOnInit(): void {
    this.loadForm=this.formBuilder.group({
      pickupDate: ['', Validators.required],
      pickupLocation: ['', Validators.required],
      dropDate: ['', [Validators.required]],
      dropLocation: ['', [Validators.required]],
      itemType: ['', Validators.required],
      bookingDate: ['', [Validators.required]],
    });

  }

  create(){

    this.truckLoad.pickupDate=this.loadForm.controls['pickupDate'].value;
    this.truckLoad.pickupLocation=this.loadForm.controls['pickupLocation'].value;
    this.truckLoad.dropDate=this.loadForm.controls['dropDate'].value;
    this.truckLoad.dropLocation=this.loadForm.controls['dropLocation'].value;
    this.truckLoad.itemType=this.loadForm.controls['itemType'].value;
    this.truckLoad.bookingDate=this.loadForm.controls['bookingDate'].value;

    this.service.createLoad(this.truckLoad).subscribe(
      data=>{
        this.snackbar.open("Truck Load Created !!");
      },error=>{
        this.snackbar.open("Something went wrong!!");
      }
    );
  }
}
