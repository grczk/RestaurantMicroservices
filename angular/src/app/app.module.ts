import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { NavComponent } from './component/nav/nav.component';
import { DishTypeListComponent } from './dishtype/view/dish-type-list/dish-type-list.component';
import {DishTypeService} from "./dishtype/service/dish-type.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { DishTypeEditComponent } from './dishtype/view/dish-type-edit/dish-type-edit.component';
import { DishTypeCreateComponent } from './dishtype/view/dish-type-create/dish-type-create.component';
import { DishTypeViewComponent } from './dishtype/view/dish-type-view/dish-type-view.component';
import { MenuItemListComponent } from './menuitem/view/menu-item-list/menu-item-list.component';
import {MenuItemService} from "./menuitem/service/menu-item.service";
import { MenuItemCreateComponent } from './menuitem/view/menu-item-create/menu-item-create.component';
import { MenuItemViewComponent } from './menuitem/view/menu-item-view/menu-item-view.component';
import { MenuItemEditComponent } from './menuitem/view/menu-item-edit/menu-item-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavComponent,
    DishTypeListComponent,
    DishTypeEditComponent,
    DishTypeCreateComponent,
    DishTypeViewComponent,
    MenuItemListComponent,
    MenuItemCreateComponent,
    MenuItemViewComponent,
    MenuItemEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    DishTypeService,
    MenuItemService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
