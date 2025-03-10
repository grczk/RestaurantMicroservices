import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MenuItem} from "../../model/menu-item";
import {MenuItemService} from "../../service/menu-item.service";
import {DishType} from "../../../dishtype/model/dish-type";
import {DishTypeService} from "../../../dishtype/service/dish-type.service";

@Component({
  selector: 'app-menu-item-view',
  templateUrl: './menu-item-view.component.html',
  styleUrls: ['./menu-item-view.component.css']
})
export class MenuItemViewComponent implements OnInit {

  menuItem: MenuItem | undefined;
  dishType: DishType | undefined;

  constructor(private menuItemService: MenuItemService, private dishTypeService: DishTypeService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.menuItemService.getMenuItem(params['menuItemId'])
        .subscribe(menuItem => this.menuItem = menuItem)
      this.dishTypeService.getDishType(params['dishTypeId'])
        .subscribe(dishType => this.dishType = dishType)
    });
  }

}
