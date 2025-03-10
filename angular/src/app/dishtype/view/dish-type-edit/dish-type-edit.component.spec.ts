import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DishTypeEditComponent } from './dish-type-edit.component';

describe('DishTypeEditComponent', () => {
  let component: DishTypeEditComponent;
  let fixture: ComponentFixture<DishTypeEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DishTypeEditComponent]
    });
    fixture = TestBed.createComponent(DishTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
