import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginActions } from './login-actions';

describe('LoginActions', () => {
  let component: LoginActions;
  let fixture: ComponentFixture<LoginActions>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginActions],
    }).compileComponents();

    fixture = TestBed.createComponent(LoginActions);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
