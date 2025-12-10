import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdicionarGeneros } from './adicionar-generos';

describe('AdicionarGeneros', () => {
  let component: AdicionarGeneros;
  let fixture: ComponentFixture<AdicionarGeneros>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdicionarGeneros]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdicionarGeneros);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
