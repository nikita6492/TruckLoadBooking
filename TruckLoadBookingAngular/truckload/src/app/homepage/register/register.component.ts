import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { TlbService } from '../../tlb.service';
import { User } from 'src/app/user';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit {

  userForm!:FormGroup;
  countries!: any;
  states!: any;
  cities!: any;
  user=new User();
  maxDate=new Date();
  response!:any;
  userRole=['Admin','Driver'];


  constructor(private service:TlbService,private formBuilder:FormBuilder, private snackbar:MatSnackBar, private route:Router) { 
    
  }

  ngOnInit(): void {
    this.userForm=this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required,Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}")]],
      password: ['', [Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]],
      dob: ['', Validators.required],
      contactNo: ['', [Validators.required,Validators.pattern("^[0-9]*$"),Validators.maxLength(10)]],
      pan: ['', [Validators.required, Validators.pattern("^[a-zA-Z0-9]*$"),Validators.maxLength(12)]],
      role: ['', Validators.required],
      country: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
    });

    this.service.getCountries().subscribe(data=>{
      this.countries=data;
      console.log(this.countries);
    });
      console.log(this.countries);
      
      
      this.userForm.controls['country'].valueChanges.subscribe((country) => {
        this.userForm.controls['state'].reset();
        this.userForm.controls['state'].disable();
        if (country) {
         this.service.getStates(country).subscribe(
           data=>{this.states=data;
          console.log(this.states)}
  
         );
          this.userForm.controls['state'].enable();
        }
      });
  
      this.userForm.controls['state'].valueChanges.subscribe((state) => {
        this.userForm.controls['city'].reset();
        this.userForm.controls['city'].disable();
        if (state) {
          this.service.getCities(state).subscribe(data=>{
            this.cities=data;
            console.log(this.cities);
          });
          this.userForm.controls['city'].enable();
        }
      });
  
    
  }
  

  addUser(){
    this.user.firstName=this.userForm.controls['firstName'].value;
    this.user.lastName=this.userForm.controls['lastName'].value;
    this.user.email=this.userForm.controls['email'].value;
    this.user.password=this.userForm.controls['password'].value;
    this.user.pan=this.userForm.controls['pan'].value;
    this.user.contactNo=this.userForm.controls['contactNo'].value;
    this.user.role=this.userForm.controls['role'].value;
    this.user.dob=this.userForm.controls['dob'].value;
    this.user.country=this.userForm.controls['country'].value;
    this.user.state=this.userForm.controls['state'].value;
    this.user.city=this.userForm.controls['city'].value;
    this.service.register(this.user).subscribe(
      data=>{
        this.response=data;
        console.log(this.response);
        if(this.response=="Already Registered"){
        this.snackbar.open("Already Registered");
        }else if(this.response=="Age Issue"){
          this.snackbar.open("Age should be greater than 18 !!")
        }else if(this.response=="User Created"){
          this.snackbar.open("User Created !!")
        }
      },
      error=>{
        console.log(error);
        this.snackbar.open("Something went wrong!!");
      }
    );
  }
}
