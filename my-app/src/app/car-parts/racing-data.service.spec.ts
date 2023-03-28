import { TestBed } from '@angular/core/testing';

import { RacingDataService } from './racing-data.service';

describe('RacingDataService', () => {
  let service: RacingDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RacingDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
