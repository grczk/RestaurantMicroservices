import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DishTypeViewComponent } from './dish-type-view.component';

describe('DishTypeViewComponent', () => {
  let component: DishTypeViewComponent;
  let fixture: ComponentFixture<DishTypeViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DishTypeViewComponent]
    });
    fixture = TestBed.createComponent(DishTypeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
