import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TlbService } from '../../tlb.service';
import { User } from 'src/app/user';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  userForm!:FormGroup;
  msg:string='';
  user=new User();
  response!:any;
  constructor(private formBuilder: FormBuilder, private _service:TlbService,private _route:Router,private _snackbar:MatSnackBar) { }

  ngOnInit(): void {

    this.userForm=this.formBuilder.group({
      email: ['', [Validators.required,Validators.pattern("[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,}")]],
      password: ['', [Validators.required]],
    });
  }

  login(){
    console.log(this.userForm.controls['email'].value);
    console.log(this.userForm.controls['password'].value);
    this.user.email=this.userForm.controls['email'].value;
    this.user.password=this.userForm.controls['password'].value;

    this._service.login(this.user).subscribe(
      data=>{
        this.response=data;
        sessionStorage.setItem("user_email",this.user.email);
        
        console.log(this.response);
        if(this.response=="Driver"){
          this._route.navigate(['/driver']);
          this._snackbar.open("User Successfully Logged In!!");
        }else if(this.response=="Admin"){
          this._route.navigate(['/admin']);
          this._snackbar.open("User Successfully Logged In!!");
        }
      },error=>{
        this._snackbar.open("Something went wrong !!");
      }
      )

  }

}
