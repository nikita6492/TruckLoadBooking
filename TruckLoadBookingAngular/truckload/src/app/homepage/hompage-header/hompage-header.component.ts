import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { SignInComponent } from '../sign-in/sign-in.component';

@Component({
  selector: 'app-hompage-header',
  templateUrl: './hompage-header.component.html',
  styleUrls: ['./hompage-header.component.css']
})
export class HompageHeaderComponent implements OnInit {

  constructor(private route:Router, private dialog:MatDialog) { }

  ngOnInit(): void {
  }


  login(): void {
    const dialogRef = this.dialog.open(SignInComponent);
    console.log("login button clicked");
  }
  register(): void { 
    const dialogRef = this.dialog.open(RegisterComponent);
    console.log("register button clicked");
  }
}
