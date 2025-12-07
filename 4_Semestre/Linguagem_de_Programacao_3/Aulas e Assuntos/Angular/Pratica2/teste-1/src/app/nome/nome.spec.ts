import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Nome } from './nome';

describe('Nome', () => {
  let component: Nome;
  let fixture: ComponentFixture<Nome>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Nome]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Nome);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
