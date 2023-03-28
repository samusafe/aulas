import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { CarPart } from './car-parts';

@Injectable({
  providedIn: 'root'
})
export class RacingDataService {

  constructor(private http: HttpClient) { }

  getCarParts() {
    return this.http.get<CarPart[]>('/assets/car-parts.json');
  }
}
