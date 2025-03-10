import { Component, OnInit } from '@angular/core';
import { DishTypeService } from '../../service/dish-type.service';
import { DishType } from '../../model/dish-type';
import {DishTypes} from "../../model/dish-types";

@Component({
  selector: 'app-dish-type-list',
  templateUrl: './dish-type-list.component.html',
  styleUrls: ['./dish-type-list.component.css']
})
export class DishTypeListComponent implements OnInit {
  constructor(private service: DishTypeService) {}

  dishTypes: DishTypes | undefined;

  ngOnInit(): void {
    this.service.getDishTypes().subscribe(dishTypes => this.dishTypes = dishTypes);
  }
  onDelete(dishType: DishType): void {
    this.service.deleteDishType(dishType.id).subscribe(() => this.ngOnInit());
  }
}
