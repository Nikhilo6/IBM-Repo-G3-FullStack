import { TestBed } from '@angular/core/testing';

import { AddprofService } from './addprof.service';

describe('AddprofService', () => {
  let service: AddprofService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddprofService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
