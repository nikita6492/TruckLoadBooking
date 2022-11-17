import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-diver-header',
  templateUrl: './diver-header.component.html',
  styleUrls: ['./diver-header.component.css']
})
export class DiverHeaderComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit(): void {
  }

  logout(){

    this.route.navigate(['/logout']);

  }
  search(){
    
  }
}
