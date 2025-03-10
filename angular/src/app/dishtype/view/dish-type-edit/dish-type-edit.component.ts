import {Component, OnInit} from '@angular/core';
import {DishType} from "../../model/dish-type";
import {DishTypeService} from "../../service/dish-type.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dish-type-edit',
  templateUrl: './dish-type-edit.component.html',
  styleUrls: ['./dish-type-edit.component.css']
})
export class DishTypeEditComponent implements OnInit  {
  id: string | undefined
  dishType: DishType | undefined
  original: DishType | undefined
  constructor(
    private dishTypeService: DishTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.dishTypeService.getDishType(params['id'])
        .subscribe(dishType => {
          this.id = dishType.id;
          this.dishType = {
            name: dishType.name,
            number: dishType.number,
            id: dishType.id
          };
          this.original = {...this.dishType};
        });
      })
    }

  onSubmit(): void {
    this.dishTypeService.patchDishType(this.id!, this.dishType!)
      .subscribe(() => this.router.navigate(['/dish-types']));
  }
}

