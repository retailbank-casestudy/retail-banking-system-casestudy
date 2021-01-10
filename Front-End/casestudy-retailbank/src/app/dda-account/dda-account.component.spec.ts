import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DdaAccountComponent } from './dda-account.component';

describe('DdaAccountComponent', () => {
  let component: DdaAccountComponent;
  let fixture: ComponentFixture<DdaAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DdaAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DdaAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
