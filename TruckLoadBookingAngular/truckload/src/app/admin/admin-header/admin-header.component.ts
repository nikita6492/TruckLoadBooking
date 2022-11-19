import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { CreateLoadComponent } from '../create-load/create-load.component';
import { AdminSearchComponent } from '../admin-search/admin-search.component';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private route:Router, private dialog:MatDialog) { }

  ngOnInit(): void {
  }

  create()
{
  const dialogRef = this.dialog.open(CreateLoadComponent);
}

search(){
  const dialogRef = this.dialog.open(AdminSearchComponent);

}

logout(){
  sessionStorage.clear();
this.route.navigate(['/logout']);

}
view(){
  
}
}
