import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {Product} from "../models/Product";
import {Supplier} from "../models/Supplier";
import {SupplyService} from "../../services/supply.service";
import {ProductSupply} from "../models/ProductSupply";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatDatepicker, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatInput} from "@angular/material/input";
/**
 * Компонент для ввода поставок.
 * Отображает форму для ввода данных о поставках и список добавленных продуктов.
 */
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

  selectedSupplier: Supplier = new Supplier(0, '');
  selectedProduct: Product = new Product(0, '','');
  formQuantity: number = 0;
  formDate: Date = new Date();
  /**
   * Конструктор компонента
   * @param supplyService Сервис для работы с данными поставок
   */
  constructor(private supplyService: SupplyService) {}

  /**
   * Инициализация компонента
   * Загружает данные о поставщиках и продуктах
   */
  async ngOnInit() {
    await this.loadSuppliers();
    await this.loadProducts();
    this.leftProducts = this.allProducts;
  }
  /**
   * Загружает список поставщиков
   */
  async loadSuppliers() {
    this.suppliers = await this.supplyService.getSuppliers();
  }

  /**
   * Загружает список продуктов
   */
  async loadProducts() {
    this.allProducts = await this.supplyService.getProducts();
  }

  /**
   * Добавляет продукт в список поставок
   */
  addProduct() {
    let ps = new ProductSupply(this.selectedSupplier, this.selectedProduct, this.formQuantity, this.formDate);
    console.log(ps);
    this.suppliedProducts.push(ps);
    this.resetInputValues();
  }

  /**
   * Отправляет данные о поставке
   */
  submitSupply(){
    this.supplyService.submitSupply(this.suppliedProducts);
    this.suppliedProducts = [];
  }

  /**
   * Удаляет продукт из списка поставок.
   * @param index Индекс продукта в списке.
   */
  removeProduct(index: number) {
    this.suppliedProducts.splice(index, 1);
  }

  /**
   * Сбрасывает значения полей ввода.
   */
  resetInputValues() {
    this.selectedProduct = new Product(0, '', '');
    this.formQuantity = 0;
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
