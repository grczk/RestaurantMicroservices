import {Component, OnInit} from '@angular/core';
import {DishType} from "../../model/dish-type";
import {DishTypeService} from "../../service/dish-type.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dish-type-create',
  templateUrl: './dish-type-create.component.html',
  styleUrls: ['./dish-type-create.component.css']
})
export class DishTypeCreateComponent{
  dishType: DishType  = {
    name: "",
    number: 0,
    id: ""
  };
  constructor(
    private dishTypeService: DishTypeService,
    private router: Router
  ) { }
  onSubmit(): void {
    this.dishTypeService.putDishType(this.dishType!)
      .subscribe(() => this.router.navigate(['/dish-types']));
  }
}
