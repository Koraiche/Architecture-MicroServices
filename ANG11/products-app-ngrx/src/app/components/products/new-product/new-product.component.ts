import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductsService} from "../../../services/products.service";
import {ProductsState, ProductStateEnum} from "../../../ngrx/products.reducer";
import {Store} from "@ngrx/store";
import {NewProductAction, SaveProductAction} from "../../../ngrx/products.actions";

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent implements OnInit {
  productFormGroup?:FormGroup;
  submitted:boolean = false;
  state:ProductsState|null=null;
  readonly ProductStateEnum = ProductStateEnum;
  constructor(private fb:FormBuilder,
              private productsService:ProductsService,
              private store:Store<any>) { }

  ngOnInit(): void {
    this.store.dispatch(new NewProductAction({}));
    this.store.subscribe(state=>{
        this.state = state.catalogueState;
      if(this.state?.dataState==ProductStateEnum.NEW){
        this.productFormGroup = this.fb.group({
          name:["",Validators.required],
          price:[0,Validators.required],
          quantity:[0,Validators.required],
          selected:[true,Validators.required],
          available:[true,Validators.required]
        });
      }
    });

  }

  onSaveProduct() {
    this.submitted=true;
    if(!this.productFormGroup.valid) return;
      this.store.dispatch(new SaveProductAction(this.productFormGroup?.value))
  }

  NewProduct() {
    this.store.dispatch(new NewProductAction({}))
  }
}
