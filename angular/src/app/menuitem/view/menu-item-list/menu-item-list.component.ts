import {Component, OnInit} from '@angular/core';
import {MenuItemService} from "../../service/menu-item.service";
import {MenuItems} from "../../model/menu-items";
import {MenuItem} from "../../model/menu-item";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-menu-item-list',
  templateUrl: './menu-item-list.component.html',
  styleUrls: ['./menu-item-list.component.css']
})
export class MenuItemListComponent implements OnInit {
  constructor(private service: MenuItemService, private route: ActivatedRoute, private router: Router) {}

  menuItems: MenuItems | undefined;
  dishTypeId : string | undefined;

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.dishTypeId = params['id'];
      this.service.getMenuItemsFromDishType(params['id'])
        .subscribe(menuItems => this.menuItems = menuItems)
    });
  }
  onDelete(menuItem: MenuItem): void {
    this.service.deleteMenuItem(menuItem.id).subscribe(() => this.ngOnInit());
  }
}
