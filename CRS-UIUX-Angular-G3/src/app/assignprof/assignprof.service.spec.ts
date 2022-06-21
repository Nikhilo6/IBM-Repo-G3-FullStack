import { TestBed } from '@angular/core/testing';

import { AssignprofService } from './assignprof.service';

describe('AssignprofService', () => {
  let service: AssignprofService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AssignprofService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
