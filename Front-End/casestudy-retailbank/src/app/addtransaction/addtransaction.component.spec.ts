import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddtransactionComponent } from './addtransaction.component';

describe('AddtransactionComponent', () => {
  let component: AddtransactionComponent;
  let fixture: ComponentFixture<AddtransactionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddtransactionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddtransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
