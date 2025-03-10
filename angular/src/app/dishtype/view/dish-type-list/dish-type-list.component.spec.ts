import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DishTypeListComponent } from './dish-type-list.component';

describe('DishTypeListComponent', () => {
  let component: DishTypeListComponent;
  let fixture: ComponentFixture<DishTypeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DishTypeListComponent]
    });
    fixture = TestBed.createComponent(DishTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
