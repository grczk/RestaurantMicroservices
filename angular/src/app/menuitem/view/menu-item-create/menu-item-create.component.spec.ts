import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuItemCreateComponent } from './menu-item-create.component';

describe('MenuItemCreateComponent', () => {
  let component: MenuItemCreateComponent;
  let fixture: ComponentFixture<MenuItemCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenuItemCreateComponent]
    });
    fixture = TestBed.createComponent(MenuItemCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
