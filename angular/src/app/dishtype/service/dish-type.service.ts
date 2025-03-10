import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DishType} from "../model/dish-type";
import {DishTypes} from "../model/dish-types";

@Injectable()
export class DishTypeService {
  constructor(private http: HttpClient) {}

  getDishTypes(): Observable<DishTypes> {
    return this.http.get<DishTypes>('/api/dish-types');
  }

  getDishType(id: string): Observable<DishType> {
    return this.http.get<DishType>('/api/dish-types/' + id);
  }

  deleteDishType(id: string): Observable<any> {
    return this.http.delete('/api/dish-types/' + id);
  }

  patchDishType(id: string, request: DishType): Observable<any> {
    return this.http.patch('/api/dish-types/' + id, request);
  }

  putDishType(request: DishType): Observable<any> {
    return this.http.put('/api/dish-types', request);
  }
}
