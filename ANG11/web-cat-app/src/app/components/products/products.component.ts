import { Component, OnInit } from '@angular/core';
import {ProductsService} from "../../services/products.service";
import {Product} from "../../model/product.model";
import {catchError, map, Observable, of, startWith} from "rxjs";
import {ActionEvent, AppDataState, DataStateEnum, ProductActionsTypes} from "../../state/product.state";
import {Router} from "@angular/router";
import {EventDriverService} from "../../services/event.driver.service";
import {$e} from "@angular/compiler/src/chars";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products$: Observable<AppDataState<Product[]>>|null=null;
  readonly DataStateEnum = DataStateEnum;
  constructor(private productService:ProductsService,
              private router:Router,
              private eventDrivenService:EventDriverService) { }

  ngOnInit(): void {
    this.eventDrivenService.sourceEventSubjectObservable.subscribe((actionEvent:ActionEvent)=>{
      this.onActionEvent(actionEvent);
    });
  }
  onGetAllProducts(){
    this.products$ = this.productService.getAllProducts().pipe(
      map((data: any)=>({dataState:DataStateEnum.LOADED,data:data })),
      startWith({dataState:DataStateEnum.LOADING}),
      catchError(err=>of({dataState:DataStateEnum.ERROR,errorMessage:err.message}))
    );
  }
  onGetSelectedProducts(){
    this.products$ = this.productService.getSelectedProducts().pipe(
      map((data: any)=>({dataState:DataStateEnum.LOADED,data:data })),
      startWith({dataState:DataStateEnum.LOADING}),
      catchError(err=>of({dataState:DataStateEnum.ERROR,errorMessage:err.message}))
    );
  }
  onGetAvailableProducts(){
    this.products$ = this.productService.getAvailableProducts().pipe(
      map((data: any)=>({dataState:DataStateEnum.LOADED,data:data })),
      startWith({dataState:DataStateEnum.LOADING}),
      catchError(err=>of({dataState:DataStateEnum.ERROR,errorMessage:err.message}))
    );
  }
  onSearch(dataForm: any){
    this.products$ = this.productService.SearchProducts(dataForm.keyWord).pipe(
      map((data: any)=>({dataState:DataStateEnum.LOADED,data:data })),
      startWith({dataState:DataStateEnum.LOADING}),
      catchError(err=>of({dataState:DataStateEnum.ERROR,errorMessage:err.message}))
    );
  }

  onSelect(p:Product) {
    this.productService.selectProduct(p).subscribe(data=>{
      p.selected = data.selected;
    });

  }

  onDelete(p: Product) {
    let v=confirm("Etes-vous sure de vouloir supprimer ?");
    if(v==true){
      this.productService.deleteProduct(p).subscribe(data=>{
        this.onGetAllProducts();
      });
    }

  }

  onNewProduct() {
      this.router.navigateByUrl("/newProduct");
  }

  onEdit(p: Product) {
    this.router.navigateByUrl("/editProduct/"+p.id);
  }
  //premiere version not used
  onActionEvent($event:ActionEvent) {
    switch($event.type){
      case ProductActionsTypes.GET_ALL_PRODUCTS :this.onGetAllProducts();break;
      case ProductActionsTypes.GET_SELECTED_PRODUCTS :this.onGetSelectedProducts();break;
      case ProductActionsTypes.GET_AVAILABLE_PRODUCTS :this.onGetAvailableProducts();break;
      case ProductActionsTypes.SEARCH_PRODUCTS :this.onSearch($event.payload);break;
      case ProductActionsTypes.NEW_PRODUCT :this.onNewProduct();break;
      case ProductActionsTypes.SELECT_PRODUCT :this.onSelect($event.payload);break;
      case ProductActionsTypes.EDIT_PRODUCT :this.onEdit($event.payload);break;
      case ProductActionsTypes.DELETE_PRODUCT :this.onDelete($event.payload);break;
    }
  }
}
