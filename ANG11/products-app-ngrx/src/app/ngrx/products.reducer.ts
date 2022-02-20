import {Product} from "../model/product.model";
import {ProductActions, ProductsActionsTypes} from "./products.actions";
import {Action} from "@ngrx/store";

export enum ProductStateEnum{
  LOADING="Loading",
  LOADED="Loaded",
  ERROR="Erreur",
  INITIAL="Initial",
  NEW="New",
  EDIT="Edit",
  UPDATED="Updated",
}
export interface ProductsState{
  products:Product[],
  errorMessage:string,
  dataState:ProductStateEnum,
  currentProduct:Product|null,
  currentAction:ProductActions|null
}
const initState:ProductsState = {
  products:[],
  errorMessage:"",
  dataState:ProductStateEnum.INITIAL,
  currentProduct:null,
  currentAction:null
}
export function productReducer(state:ProductsState=initState, action:Action):ProductsState{
  switch(action.type){
    case ProductsActionsTypes.GET_ALL_PRODUCTS:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.GET_ALL_PRODUCTS_SUCCESS:
      return {...state, dataState:ProductStateEnum.LOADED, products:(<ProductActions>action).payload, currentAction:<ProductActions>action}
    case ProductsActionsTypes.GET_ALL_PRODUCTS_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}

    case ProductsActionsTypes.GET_SELECTED_PRODUCTS:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.GET_SELECTED_PRODUCTS_SUCCESS:
      return {...state, dataState:ProductStateEnum.LOADED, products:(<ProductActions>action).payload, currentAction:<ProductActions>action}
    case ProductsActionsTypes.GET_SELECTED_PRODUCTS_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}


    case ProductsActionsTypes.SEARCH_PRODUCTS:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SEARCH_PRODUCTS_SUCCESS:
      return {...state, dataState:ProductStateEnum.LOADED, products:(<ProductActions>action).payload, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SEARCH_PRODUCTS_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}

    case ProductsActionsTypes.SELECT_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SELECT_PRODUCT_SUCCESS:
      let product:Product = (<ProductActions>action).payload;
      let listProducts=[...state.products];
      let data:Product[] = listProducts.map(p=>p.id==product.id?product:p);
      return {...state, dataState:ProductStateEnum.LOADED, products: data, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SELECT_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}




    case ProductsActionsTypes.DELETE_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.DELETE_PRODUCT_SUCCESS:
      let p:Product = (<ProductActions>action).payload;
      let index = state.products.indexOf(p);
      let productsList=[...state.products];
      productsList.splice(index,1);
      return {...state, dataState:ProductStateEnum.LOADED, products: productsList, currentAction:<ProductActions>action}
    case ProductsActionsTypes.DELETE_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}



    case ProductsActionsTypes.NEW_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.NEW_PRODUCT_SUCCESS:
      return {...state, dataState:ProductStateEnum.NEW, currentAction:<ProductActions>action}
    case ProductsActionsTypes.NEW_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}


    case ProductsActionsTypes.SAVE_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SAVE_PRODUCT_SUCCESS:
      let prods=[...state.products];
      prods.push((<ProductActions>action).payload)
      return {...state, dataState:ProductStateEnum.LOADED,products:prods, currentAction:<ProductActions>action}
    case ProductsActionsTypes.SAVE_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}





    case ProductsActionsTypes.EDIT_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.EDIT_PRODUCT_SUCCESS:
      return {...state, dataState:ProductStateEnum.LOADED,currentProduct:(<ProductActions>action).payload, currentAction:<ProductActions>action}
    case ProductsActionsTypes.EDIT_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}




    case ProductsActionsTypes.UPDATE_PRODUCT:
      return {...state, dataState:ProductStateEnum.LOADING, currentAction:<ProductActions>action}
    case ProductsActionsTypes.UPDATE_PRODUCT_SUCCESS:
      let updatedProduct:Product= (<ProductActions>action).payload;
      let updatedProducts=state.products.map(p=>(p.id==updatedProduct.id)?updatedProduct:p);
      return {...state, dataState:ProductStateEnum.UPDATED,products:updatedProducts, currentAction:<ProductActions>action}
    case ProductsActionsTypes.UPDATE_PRODUCT_ERROR:
      return {...state, dataState:ProductStateEnum.ERROR, errorMessage:(<ProductActions>action).payload, currentAction:<ProductActions>action}




    default: return {...state}
  }
}
