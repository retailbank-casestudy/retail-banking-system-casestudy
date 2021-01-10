import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SavingsAccountComponent } from './savings-account.component';

describe('SavingsAccountComponent', () => {
  let component: SavingsAccountComponent;
  let fixture: ComponentFixture<SavingsAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SavingsAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SavingsAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
