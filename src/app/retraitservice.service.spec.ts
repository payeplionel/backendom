import { TestBed } from '@angular/core/testing';

import { RetraitserviceService } from './retraitservice.service';

describe('RetraitserviceService', () => {
  let service: RetraitserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RetraitserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
