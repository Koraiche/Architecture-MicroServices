import {Injectable} from "@angular/core";
import {ProductsService} from "../services/products.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {catchError, map, mergeMap, Observable, of} from "rxjs";
import {Action} from "@ngrx/store";
import {
  DeleteProductActionError,
  DeleteProductActionSuccess, EditProductActionError, EditProductActionSuccess,
  GetAllProductsActionError,
  GetAllProductsActionSuccess,
  GetSelectedProductsActionError,
  GetSelectedProductsActionSuccess, NewProductAction, NewProductActionSuccess,
  ProductActions,
  ProductsActionsTypes, SaveProductActionError, SaveProductActionSuccess,
  SearchProductsActionError,
  SearchProductsActionSuccess,
  SelectProductActionError,
  SelectProductActionSuccess, UpdateProductActionError, UpdateProductActionSuccess
} from "./products.actions";
import {Product} from "../model/product.model";

@Injectable()
export class ProductsEffects{


    constructor(private productService:ProductsService, private effectActions:Actions) {

    }
    getAllProductsEffect:Observable<ProductActions> = createEffect(
      ()=>this.effectActions.pipe(
            ofType(ProductsActionsTypes.GET_ALL_PRODUCTS),
            mergeMap((action:ProductActions)=>{
              return this.productService.getAllProducts()
                .pipe(
                  map((products)=> new GetAllProductsActionSuccess(products)),
                  catchError((err)=>of(new GetAllProductsActionError(err.message())))

                )
            })
        )
    );
  getSelectedProductsEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.GET_SELECTED_PRODUCTS),
      mergeMap((action:ProductActions)=>{
        return this.productService.getSelectedProducts()
          .pipe(
            map((products)=> new GetSelectedProductsActionSuccess(products)),
            catchError((err)=>of(new GetSelectedProductsActionError(err.message())))

          )
      })
    )
  );

  searchProductsEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.SEARCH_PRODUCTS),
      mergeMap((action:ProductActions)=>{
        return this.productService.SearchProducts(action.payload)
          .pipe(
            map((products)=> new SearchProductsActionSuccess(products)),
            catchError((err)=>of(new SearchProductsActionError(err.message())))

          )
      })
    )
  );

  selectProductEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.SELECT_PRODUCT),
      mergeMap((action:ProductActions)=>{
        return this.productService.selectProduct(action.payload)
          .pipe(
            map((products)=> new SelectProductActionSuccess(products)),
            catchError((err)=>of(new SelectProductActionError(err.message())))
          )
      })
    )
  );


  deleteProductEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.DELETE_PRODUCT),
      mergeMap((action:ProductActions)=>{
        return this.productService.deleteProduct(action.payload.id)
          .pipe(
            map(()=> new DeleteProductActionSuccess(action.payload)),
            catchError((err)=>of(new DeleteProductActionError(err.message())))
          )
      })
    )
  );


  newProductEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.NEW_PRODUCT),
      map((action:ProductActions)=>{
          return new NewProductActionSuccess({})
      })
    )
  );





  saveProductsEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.SAVE_PRODUCT),
      mergeMap((action:ProductActions)=>{
        return this.productService.saveProduct(action.payload)
          .pipe(
            map((product)=> new SaveProductActionSuccess(product)),
            catchError((err)=>of(new SaveProductActionError(err.message)))
          )
      })
    )
  );



  editProductEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.EDIT_PRODUCT),
      mergeMap((action:ProductActions)=>{
        return this.productService.getProduct(action.payload)
          .pipe(
            map((product)=> new EditProductActionSuccess(product)),
            catchError((err)=>of(new EditProductActionError(err.message())))
          )
      })
    )
  );

  updateProductEffect:Observable<ProductActions> = createEffect(
    ()=>this.effectActions.pipe(
      ofType(ProductsActionsTypes.UPDATE_PRODUCT),
      mergeMap((action:ProductActions)=>{
        return this.productService.updateProduct(action.payload)
          .pipe(
            map((product)=> new UpdateProductActionSuccess(product)),
            catchError((err)=>of(new UpdateProductActionError(err.message)))
          )
      })
    )
  );

}
