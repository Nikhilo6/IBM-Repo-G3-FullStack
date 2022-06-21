import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignprofComponent } from './assignprof.component';

describe('AssignprofComponent', () => {
  let component: AssignprofComponent;
  let fixture: ComponentFixture<AssignprofComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignprofComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignprofComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
