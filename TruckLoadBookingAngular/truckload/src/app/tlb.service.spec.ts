import { TestBed } from '@angular/core/testing';

import { TlbService } from './tlb.service';

describe('TlbService', () => {
  let service: TlbService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TlbService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
