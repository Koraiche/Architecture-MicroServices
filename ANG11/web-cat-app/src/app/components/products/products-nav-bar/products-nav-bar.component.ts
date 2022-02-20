import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {catchError, map, of, startWith} from "rxjs";
import {ProductsService} from "../../../services/products.service";
import {Router} from "@angular/router";
import {ActionEvent, DataStateEnum, ProductActionsTypes} from "../../../state/product.state";
import {EventDriverService} from "../../../services/event.driver.service";

@Component({
  selector: 'app-products-nav-bar',
  templateUrl: './products-nav-bar.component.html',
  styleUrls: ['./products-nav-bar.component.css']
})
export class ProductsNavBarComponent implements OnInit {
 //@Output()
 //productEventEmitter:EventEmitter<ActionEvent> = new EventEmitter<any>();
  readonly DataStateEnum = DataStateEnum;
  constructor(private productService:ProductsService,
              private router:Router,
              private eventDrivenService:EventDriverService){ }


  ngOnInit(): void {
  }
  onGetAllProducts(){
    //this.productEventEmitter.emit({type:ProductActionsTypes.GET_ALL_PRODUCTS});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.GET_ALL_PRODUCTS});
  }
  onGetSelectedProducts(){
    //this.productEventEmitter.emit({type:ProductActionsTypes.GET_SELECTED_PRODUCTS});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.GET_SELECTED_PRODUCTS});
  }
  onGetAvailableProducts(){
    //this.productEventEmitter.emit({type:ProductActionsTypes.GET_AVAILABLE_PRODUCTS});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.GET_AVAILABLE_PRODUCTS});
  }
  onSearch(dataForm: any){
    //this.productEventEmitter.emit({type:ProductActionsTypes.SEARCH_PRODUCTS,payload:dataForm});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.SEARCH_PRODUCTS,payload:dataForm});
  }
  onNewProduct() {
    //this.productEventEmitter.emit({type:ProductActionsTypes.NEW_PRODUCT});
    this.eventDrivenService.publishEvent({type:ProductActionsTypes.NEW_PRODUCT});
  }
}
