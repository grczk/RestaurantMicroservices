import {Component, OnInit} from '@angular/core';
import {DishType} from "../../model/dish-type";
import {DishTypeService} from "../../service/dish-type.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dish-type-view',
  templateUrl: './dish-type-view.component.html',
  styleUrls: ['./dish-type-view.component.css']
})
export class DishTypeViewComponent implements OnInit {

  dishType: DishType | undefined;

  constructor(private service: DishTypeService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getDishType(params['id'])
        .subscribe(dishType => this.dishType = dishType)
    });
  }

}
