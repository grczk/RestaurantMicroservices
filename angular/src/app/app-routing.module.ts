import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DishTypeListComponent} from "./dishtype/view/dish-type-list/dish-type-list.component";
import {DishTypeEditComponent} from "./dishtype/view/dish-type-edit/dish-type-edit.component";
import {DishTypeCreateComponent} from "./dishtype/view/dish-type-create/dish-type-create.component";
import {DishTypeViewComponent} from "./dishtype/view/dish-type-view/dish-type-view.component";
import {MenuItemCreateComponent} from "./menuitem/view/menu-item-create/menu-item-create.component";
import {MenuItemViewComponent} from "./menuitem/view/menu-item-view/menu-item-view.component";
import {MenuItemEditComponent} from "./menuitem/view/menu-item-edit/menu-item-edit.component";

const routes: Routes = [
  {
    component: DishTypeListComponent,
    path: "dish-types"
  },
  {
    component: DishTypeEditComponent,
    path: "dish-types/:id/edit"
  },
  {
    component: DishTypeViewComponent,
    path: "dish-types/:id/view"
  },
  {
    component: DishTypeCreateComponent,
    path: "dish-types/create"
  },
  {
    component: MenuItemCreateComponent,
    path: "dish-types/:id/menu-items/create"
  },
  {
    component: MenuItemViewComponent,
    path: "dish-types/:dishTypeId/menu-items/:menuItemId/view"
  },
  {
    component: MenuItemEditComponent,
    path: "dish-types/:dishTypeId/menu-items/:menuItemId/edit"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
