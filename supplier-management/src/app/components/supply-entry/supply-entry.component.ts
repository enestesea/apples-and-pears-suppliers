import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {Product} from "../models/Product";
import {Supplier} from "../models/Supplier";
import {SupplyService} from "../../services/supply.service";
import {ProductSupply} from "../models/ProductSupply";
import {Supply} from "../models/Supply";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatDatepicker, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-supply-entry',
  standalone: true,
  imports: [CommonModule, FormsModule, MatLabel, MatDatepickerToggle, MatFormField, MatDatepicker, MatInput],
  templateUrl: './supply-entry.component.html',
  styleUrls: ['./supply-entry.component.css']
})
export class SupplyEntryComponent implements OnInit {
  suppliers: Supplier[] = [];
  allProducts: Product[] = [];
  leftProducts: Product[] = [];
  suppliedProducts: ProductSupply[] = [];

  supplyDate: Date = new Date();
  selectedSupplier: Supplier = new Supplier();
  selectedProduct: Product = new Product();
  formQuantity: number = 0;

  constructor(private supplyService: SupplyService) {}

  async ngOnInit() {
    await this.loadSuppliers();
    await this.loadProducts();
    this.leftProducts = this.allProducts;
  }

  async loadSuppliers() {
    this.suppliers = await this.supplyService.getSuppliers();
  }

  async loadProducts() {
    this.allProducts = await this.supplyService.getProducts();
  }

  addProduct() {
    let ps = new ProductSupply(this.selectedSupplier, this.selectedProduct, this.formQuantity);
    console.log(ps);
    this.suppliedProducts.push(ps);
    this.resetInputValues();
  }

  removeProduct(index: number) {
    this.suppliedProducts.splice(index, 1);
  }

  resetInputValues() {
    this.selectedSupplier = new Supplier();
    this.selectedProduct = new Product();
    this.formQuantity = 0;
  }

  isValid(): boolean {
    return true;
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
}
