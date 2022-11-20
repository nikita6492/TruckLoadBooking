import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { CreateLoadComponent } from '../create-load/create-load.component';
import { AdminSearchComponent } from '../admin-search/admin-search.component';
import { ViewComponent } from '../view/view.component';
import { TlbService } from 'src/app/tlb.service';
import { Truckload } from 'src/app/truckload';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  truckLoadDetails!:any;
  constructor(private route:Router, private dialog:MatDialog, private tlbservice: TlbService) { }

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

  this.tlbservice.viewLoad().subscribe(
    data=>{
      this.truckLoadDetails=data;
      this.dialog.open(ViewComponent,{
        data:this.truckLoadDetails
      })
    }
  )
}
}
