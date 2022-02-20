import {Action} from "@ngrx/store";
import {Product} from "../model/product.model";

export enum ProductsActionsTypes{
  GET_ALL_PRODUCTS="[Products] Get all products",
  GET_ALL_PRODUCTS_SUCCESS="[Products] Get all products success",
  GET_ALL_PRODUCTS_ERROR="[Products] Get all products error",

  GET_SELECTED_PRODUCTS="[Products] Get selected products",
  GET_SELECTED_PRODUCTS_SUCCESS="[Products] Get selected products success",
  GET_SELECTED_PRODUCTS_ERROR="[Products] Get selected products error",

  SEARCH_PRODUCTS="[Products] Search selected products",
  SEARCH_PRODUCTS_SUCCESS="[Products] Search selected products success",
  SEARCH_PRODUCTS_ERROR="[Products] Search selected products error",

  SELECT_PRODUCT="[Products] Select  product",
  SELECT_PRODUCT_SUCCESS="[Products] Select product success",
  SELECT_PRODUCT_ERROR="[Products] Select product error",

  DELETE_PRODUCT="[Products] Delete  product",
  DELETE_PRODUCT_SUCCESS="[Products] Delete product success",
  DELETE_PRODUCT_ERROR="[Products] Delete product error",

  NEW_PRODUCT="[Products] New  product",
  NEW_PRODUCT_SUCCESS="[Products] New product success",
  NEW_PRODUCT_ERROR="[Products] New product error",

  SAVE_PRODUCT="[Products] Save  product",
  SAVE_PRODUCT_SUCCESS="[Products] Save product success",
  SAVE_PRODUCT_ERROR="[Products] Save product error",

  EDIT_PRODUCT="[Products] Edit  product",
  EDIT_PRODUCT_SUCCESS="[Products] Edit product success",
  EDIT_PRODUCT_ERROR="[Products] Edit product error",

  UPDATE_PRODUCT="[Products] Update  product",
  UPDATE_PRODUCT_SUCCESS="[Products] Update product success",
  UPDATE_PRODUCT_ERROR="[Products] Update product error"
}
export class GetAllProductsAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_ALL_PRODUCTS;
  constructor(public payload:any){}

}
export class GetAllProductsActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_ALL_PRODUCTS_SUCCESS;
  constructor(public payload:Product[]){}

}
export class GetAllProductsActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_ALL_PRODUCTS_ERROR;
  constructor(public payload:string){}

}



export class GetSelectedProductsAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_SELECTED_PRODUCTS;
  constructor(public payload:any){}

}
export class GetSelectedProductsActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_SELECTED_PRODUCTS_SUCCESS;
  constructor(public payload:Product[]){}

}
export class GetSelectedProductsActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.GET_SELECTED_PRODUCTS_ERROR;
  constructor(public payload:string){}

}



export class SearchProductsAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SEARCH_PRODUCTS;
  constructor(public payload:any){}

}
export class SearchProductsActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SEARCH_PRODUCTS_SUCCESS;
  constructor(public payload:Product[]){}

}
export class SearchProductsActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SEARCH_PRODUCTS_ERROR;
  constructor(public payload:string){}

}





export class SelectProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SELECT_PRODUCT;
  constructor(public payload:any){}

}
export class SelectProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SELECT_PRODUCT_SUCCESS;
  constructor(public payload:Product){}

}
export class SelectProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SELECT_PRODUCT_ERROR;
  constructor(public payload:string){}

}


export class DeleteProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.DELETE_PRODUCT;
  constructor(public payload:any){}

}
export class DeleteProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.DELETE_PRODUCT_SUCCESS;
  constructor(public payload:Product){}

}
export class DeleteProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.DELETE_PRODUCT_ERROR;
  constructor(public payload:string){}

}


export class NewProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.NEW_PRODUCT;
  constructor(public payload:any){}

}
export class NewProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.NEW_PRODUCT_SUCCESS;
  constructor(public payload:any){}

}
export class NewProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.NEW_PRODUCT_ERROR;
  constructor(public payload:string){}

}




export class SaveProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SAVE_PRODUCT;
  constructor(public payload:Product){}

}
export class SaveProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SAVE_PRODUCT_SUCCESS;
  constructor(public payload:Product){}

}
export class SaveProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.SAVE_PRODUCT_ERROR;
  constructor(public payload:string){}

}





export class EditProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.EDIT_PRODUCT;
  constructor(public payload:number){}

}
export class EditProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.EDIT_PRODUCT_SUCCESS;
  constructor(public payload:Product){}

}
export class EditProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.EDIT_PRODUCT_ERROR;
  constructor(public payload:string){}

}





export class UpdateProductAction implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.UPDATE_PRODUCT;
  constructor(public payload:Product){}

}
export class UpdateProductActionSuccess implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.UPDATE_PRODUCT_SUCCESS;
  constructor(public payload:Product){}

}
export class UpdateProductActionError implements Action{
  type:ProductsActionsTypes = ProductsActionsTypes.UPDATE_PRODUCT_ERROR;
  constructor(public payload:string){}

}




export type ProductActions =
  GetAllProductsAction | GetAllProductsActionSuccess | GetAllProductsActionError |
  GetSelectedProductsAction | GetSelectedProductsActionSuccess | GetSelectedProductsActionError |
  SearchProductsAction | SearchProductsActionSuccess | SearchProductsActionError |
  SelectProductAction | SelectProductActionSuccess | SelectProductActionError |
  DeleteProductAction | DeleteProductActionSuccess | DeleteProductActionError |
  NewProductAction | NewProductActionSuccess | NewProductActionError |
  SaveProductAction | SaveProductActionSuccess | SaveProductActionError |
  EditProductAction | EditProductActionSuccess | EditProductActionError |
  UpdateProductAction | UpdateProductActionSuccess | UpdateProductActionError
  ;
