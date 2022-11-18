import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/user';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  userForm!:FormGroup;
  msg:string='';
  user!:User;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.userForm=this.formBuilder.group({
      email: ['', [Validators.required,Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}")]],
      password: ['', [Validators.required,Validators.pattern("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")]],
    });
  }

  login(){
    this.user.email=this.userForm.controls['email'].value;
    this.user.password=this.userForm.controls['password'].value;
  }

}
