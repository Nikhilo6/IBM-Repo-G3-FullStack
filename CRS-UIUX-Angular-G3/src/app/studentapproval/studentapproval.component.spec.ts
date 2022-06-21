import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentapprovalComponent } from './studentapproval.component';

describe('StudentapprovalComponent', () => {
  let component: StudentapprovalComponent;
  let fixture: ComponentFixture<StudentapprovalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentapprovalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentapprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
