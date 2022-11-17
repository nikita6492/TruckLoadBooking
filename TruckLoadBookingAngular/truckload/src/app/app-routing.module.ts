import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminPageComponent } from './admin/admin-page/admin-page.component';
import { DriverPageComponent } from './driver/driver-page/driver-page.component';
import { HomeComponent } from './homepage/home/home.component';
import { RegisterComponent } from './homepage/register/register.component';
import { SignInComponent } from './homepage/sign-in/sign-in.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:SignInComponent},
  {path:'logout',component:HomeComponent},
  {path:'driver',component:DriverPageComponent},
  {path:'admin',component:AdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
