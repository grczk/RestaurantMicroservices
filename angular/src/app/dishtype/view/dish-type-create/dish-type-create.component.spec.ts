import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DishTypeCreateComponent } from './dish-type-create.component';

describe('DishTypeCreateComponent', () => {
  let component: DishTypeCreateComponent;
  let fixture: ComponentFixture<DishTypeCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DishTypeCreateComponent]
    });
    fixture = TestBed.createComponent(DishTypeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
