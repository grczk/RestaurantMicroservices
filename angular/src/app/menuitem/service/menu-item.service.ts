import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MenuItems} from "../model/menu-items";
import {MenuItem} from "../model/menu-item";

@Injectable()
export class MenuItemService {
  constructor(private http: HttpClient) {}

  getMenuItems(): Observable<MenuItems> {
    return this.http.get<MenuItems>('/api/menu-items');
  }

  getMenuItemsFromDishType(id: string): Observable<MenuItems> {
    return this.http.get<MenuItems>('/api/menu-items/from/' + id);
  }

  getMenuItem(id: string): Observable<MenuItem> {
    return this.http.get<MenuItem>('/api/menu-items/' + id);
  }

  deleteMenuItem(id: string): Observable<any> {
    return this.http.delete('/api/menu-items/' + id);
  }

  patchMenuItem(id: string, request: MenuItem): Observable<any> {
    return this.http.patch('/api/menu-items/' + id, request);
  }

  putMenuItem(request: MenuItem): Observable<any> {
    return this.http.put('/api/menu-items', request);
  }
}
