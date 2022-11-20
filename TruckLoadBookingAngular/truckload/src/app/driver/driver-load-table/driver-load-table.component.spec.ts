import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverLoadTableComponent } from './driver-load-table.component';

describe('DriverLoadTableComponent', () => {
  let component: DriverLoadTableComponent;
  let fixture: ComponentFixture<DriverLoadTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DriverLoadTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverLoadTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
