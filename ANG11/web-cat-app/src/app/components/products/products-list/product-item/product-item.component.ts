import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../../../model/product.model";
import {ActionEvent, ProductActionsTypes} from "../../../../state/product.state";
import {EventDriverService} from "../../../../services/event.driver.service";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  @Input() p:Product|null=null;
  //@Output() eventEmitter:EventEmitter<ActionEvent> = new EventEmitter<ActionEvent>();
  constructor(private eventDrivenService:EventDriverService) { }

  ngOnInit(): void {
  }

  onSelect(p: Product) {
    //this.eventEmitter.emit({type:ProductActionsTypes.SELECT_PRODUCT, payload:p});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.SELECT_PRODUCT, payload:p});
  }

  onDelete(p: Product) {
    //this.eventEmitter.emit({type:ProductActionsTypes.DELETE_PRODUCT, payload:p});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.DELETE_PRODUCT, payload:p});
  }

  onEdit(p: Product) {
    //this.eventEmitter.emit({type:ProductActionsTypes.EDIT_PRODUCT, payload:p});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.EDIT_PRODUCT, payload:p});

  }
}
