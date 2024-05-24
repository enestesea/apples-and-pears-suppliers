import {Product} from "./Product";
import {Supplier} from "./Supplier";

export interface ProductPrice {
  id: number;
  supplier_id: number;
  product_idt: number;
  price: number;
  startDate: Date;
  endDate: Date;
}
