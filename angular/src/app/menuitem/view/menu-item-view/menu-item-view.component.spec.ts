import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuItemViewComponent } from './menu-item-view.component';

describe('MenuItemViewComponent', () => {
  let component: MenuItemViewComponent;
  let fixture: ComponentFixture<MenuItemViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenuItemViewComponent]
    });
    fixture = TestBed.createComponent(MenuItemViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
