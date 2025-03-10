import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MenuItemService} from "../../service/menu-item.service";
import {MenuItem} from "../../model/menu-item";

@Component({
  selector: 'app-menu-item-edit',
  templateUrl: './menu-item-edit.component.html',
  styleUrls: ['./menu-item-edit.component.css']
})
export class MenuItemEditComponent implements OnInit  {
  id: string | undefined
  menuItem: MenuItem | undefined
  original: MenuItem | undefined
  constructor(
    private menuItemService: MenuItemService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.menuItemService.getMenuItem(params['menuItemId'])
        .subscribe(menuItem => {
          this.id = menuItem.id;
          this.menuItem = {
            name: menuItem.name,
            price: menuItem.price,
            id: menuItem.id,
            dishTypeId: menuItem.dishTypeId
          };
          this.original = {...this.menuItem};
        });
    })
  }

  onSubmit(): void {
    this.route.params.subscribe(params => {
      this.menuItemService.patchMenuItem(this.id!, this.menuItem!)
        .subscribe(() => this.router.navigate(['dish-types',params['dishTypeId'], 'view']));
    })
  }
}
