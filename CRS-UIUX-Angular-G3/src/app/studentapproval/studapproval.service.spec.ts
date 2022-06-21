import { TestBed } from '@angular/core/testing';

import { StudapprovalService } from './studapproval.service';

describe('StudapprovalService', () => {
  let service: StudapprovalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudapprovalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
