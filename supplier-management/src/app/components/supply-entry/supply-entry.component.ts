import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {Product} from "../models/Product";
import {Supplier} from "../models/Supplier";
import {SupplyService} from "../../services/supply.service";
import {ProductView} from "../models/ProductView";

@Component({
  selector: 'app-supply-entry',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './supply-entry.component.html',
  styleUrls: ['./supply-entry.component.css']
})
export class SupplyEntryComponent implements OnInit {
  suppliers: Supplier[] = [];
  products: Product[] = [];
  selectedSupplier?: Supplier;
  suppliedProducts: ProductView[] = [];

  constructor(private http: HttpClient, private supplyService: SupplyService) {}

  async ngOnInit() {
    this.suppliers = await this.supplyService.getSuppliers();
    this.products = await this.supplyService.getProducts();
  }

  addProduct() {
    this.products.push({ name: '', quantity: 0, price: 0 });
  }

  removeProduct(index: number) {
    this.products.splice(index, 1);
  }

  isValid(): boolean {
    return this.supplierName.trim() !== '' && this.products.length > 0 && this.products.every(p => p.name.trim() !== '' && p.quantity > 0 && p.price > 0);
  }

  submitSupply() {
    if (this.isValid()) {
      const supply = {
        supplierName: this.supplierName,
        products: this.products
      };
      this.http.post('/api/supplies', supply).subscribe(response => {
        console.log('Supply submitted successfully:', response);
      }, error => {
        console.error('Error submitting supply:', error);
      });
    } else {
      console.error('Invalid supply data');
    }
  }

  updateSupplierName(event: Event) {
    const target = event.target as HTMLInputElement;
    if (target) {
      this.supplierName = target.value;
    }
  }

  updateProductName(product: { name: string, quantity: number, price: number }, event: Event) {
    const target = event.target as HTMLInputElement;
    if (target) {
      product.name = target.value;
    }
  }

  updateQuantity(product: { name: string, quantity: number, price: number }, event: Event) {
    const target = event.target as HTMLInputElement;
    if (target) {
      product.quantity = +target.value;
    }
  }

  updatePrice(product: { name: string, quantity: number, price: number }, event: Event) {
    const target = event.target as HTMLInputElement;
    if (target) {
      product.price = +target.value;
    }
  }
}
