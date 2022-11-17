import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HompageHeaderComponent } from './hompage-header.component';

describe('HompageHeaderComponent', () => {
  let component: HompageHeaderComponent;
  let fixture: ComponentFixture<HompageHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HompageHeaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HompageHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
