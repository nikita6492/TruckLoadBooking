import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiverHeaderComponent } from './diver-header.component';

describe('DiverHeaderComponent', () => {
  let component: DiverHeaderComponent;
  let fixture: ComponentFixture<DiverHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiverHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiverHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
