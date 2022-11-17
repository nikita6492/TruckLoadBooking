import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  userForm!:FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.userForm=this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  login(){
    //write service calling
  }

}
