import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DiverHeaderComponent } from './diver-header/diver-header.component';
import { DriverFooterComponent } from './driver-footer/driver-footer.component';
import { DriverPageComponent } from './driver-page/driver-page.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { RouterModule } from '@angular/router';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatRadioModule} from '@angular/material/radio'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import { SearchComponent } from './search/search.component';
import { DriverViewComponent } from './driver-view/driver-view.component';
import { DriverLoadTableComponent } from './driver-load-table/driver-load-table.component';



@NgModule({
  declarations: [
    DiverHeaderComponent,
    DriverFooterComponent,
    DriverPageComponent,
    SearchComponent,
    DriverViewComponent,
    DriverLoadTableComponent
  ],
  imports: [
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    RouterModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatTableModule
  ],
  providers: [{
    provide:MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue:{duration:2500}
  }],
})
export class DriverModule { }
