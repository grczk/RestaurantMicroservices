import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MenuItem} from "../../model/menu-item";
import {MenuItemService} from "../../service/menu-item.service";
import {DishTypeService} from "../../../dishtype/service/dish-type.service";
import {DishType} from "../../../dishtype/model/dish-type";

@Component({
  selector: 'app-menu-item-create',
  templateUrl: './menu-item-create.component.html',
  styleUrls: ['./menu-item-create.component.css']
})
export class MenuItemCreateComponent implements OnInit {
  menuItem: MenuItem  = {
    name: "",
    price: 0,
    id: "",
    dishTypeId: ""
  };
  dishTypeName: string | undefined;
  constructor(
    private menuItemService: MenuItemService,
    private dishTypeService: DishTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.menuItem.dishTypeId=params['id'];
      this.dishTypeService.getDishType(params['id']).subscribe((dishType: DishType) => {
        this.dishTypeName = dishType.name;
      });
    })
  }
  onSubmit(): void {
    this.route.params.subscribe(params => {
      this.menuItemService.putMenuItem(this.menuItem!)
        .subscribe(() => this.router.navigate(['dish-types',params['id'], 'view']));
    })
  }
}
