import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { TlbService } from 'src/app/tlb.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit {

  userForm!:FormGroup;
  countries!: string[];
  states!: string[];
  cities!: string[];
  user!:User;
  maxDate=new Date();

  country = new FormControl(null, [Validators.required]);
  state = new FormControl({ value: null, disabled: true }, [
    Validators.required,
  ]);
  city = new FormControl({ value: null, disabled: true }, [
    Validators.required,
  ]);


  constructor(private service:TlbService,private formBuilder:FormBuilder) { 
    //this.countries = this.service.getCountries();
    this.userForm = new FormGroup({
      country: this.country,
      state: this.state,
      city: this.city,
    });
  }

  ngOnInit(): void {
    this.country.valueChanges.subscribe((country) => {
      this.state.reset();
      this.state.disable();
      if (country) {
       // this.states = this.service.getStatesByCountry(country);
        this.state.enable();
      }
    });

    this.state.valueChanges.subscribe((state) => {
      this.city.reset();
      this.city.disable();
      if (state) {
       // this.cities = this.service.getCitiesByState(this.country.value, state);
        this.city.enable();
      }
    });

    this.userForm=this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required,Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}")]],
      password: ['', [Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]],
      dob: ['', Validators.required],
      contactNo: ['', [Validators.required,Validators.pattern("^[0-9]*$"),Validators.minLength(10)]],
      pan: ['', [Validators.required, Validators.pattern("^[a-zA-Z0-9]*$"),Validators.minLength(12)]],
      role: ['', Validators.required],
      country: ['', Validators.required],
      state: ['', Validators.required],
      city: ['', Validators.required],
    })
  }
  

  addUser(){
    this.user.firstName=this.userForm.controls['firstName'].value;
    this.user.lastName=this.userForm.controls['lastName'].value;
    this.user.email=this.userForm.controls['email'].value;
    this.user.password=this.userForm.controls['password'].value;
  }
}
