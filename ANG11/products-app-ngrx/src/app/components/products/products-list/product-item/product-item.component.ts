import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../../../../model/product.model";
import {DeleteProductAction, SearchProductsAction, SelectProductAction} from "../../../../ngrx/products.actions";
import {Store} from "@ngrx/store";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  @Input() p:Product|null=null;
  constructor(private store:Store<any>,
              private router:Router) { }


  ngOnInit(): void {
  }

  onSelect(p: Product) {
    this.store.dispatch(new SelectProductAction(p));
  }

  onDelete(p: Product) {
    this.store.dispatch(new DeleteProductAction(p));
  }

  onEdit(p: Product) {
      this.router.navigateByUrl("/editProduct/"+p.id);
  }
}
