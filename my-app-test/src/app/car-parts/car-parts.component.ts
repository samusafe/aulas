import { Component, OnInit } from '@angular/core';
import { CarPart } from './car-parts';
import { CARPARTS } from './mocks';

@Component({
  selector: 'car-parts',
  templateUrl: './car-parts.component.html',
  styleUrls: ['./car-parts.component.css']
})
export class CarPartsComponent implements OnInit {

  carParts : CarPart[];

  totalCarParts() {
    let sum = 0;

    for (let carPart of this.carParts) {
      sum += carPart.inStock;
    }

    return sum;
  }

  constructor() {
    this.carParts = [];
  }

  ngOnInit() {
    this.carParts = CARPARTS;
  }

  upQuantity(part_auto:CarPart) {
    if(part_auto.quantity < part_auto.inStock) {
      part_auto.quantity++;
    }
  }

  downQuantity(part_auto:CarPart) {
    if(part_auto.quantity > 0) {
      part_auto.quantity--;
    }
  }

  selectPart(part_auto:CarPart) {
    part_auto.featured = true;
  }

  unselectPart(part_auto:CarPart) {
    part_auto.featured = false;
  }
}
