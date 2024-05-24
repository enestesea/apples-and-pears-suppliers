import {Supplier} from "./Supplier";
import {Product} from "./Product";

export class ProductSupply {
  constructor(public supplier: Supplier, public product: Product, public quantity: number) {

  }
}
