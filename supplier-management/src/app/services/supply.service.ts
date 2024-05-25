import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Supplier} from "../components/models/Supplier";
import {ProductSupply} from "../components/models/ProductSupply";
import {SupplyDTO} from "../components/dtos/SupplyDTO";
import {Product} from "../components/models/Product";

/**
 * @summary Сервис для работы с поставками
 * @description Этот сервис предоставляет методы для получения информации о поставщиках и продуктах,
 * а также для отправки данных о поставках
 */
@Injectable({
  providedIn: 'root',
})
export class SupplyService {
  /** Базовый URL для API запросов */
  private baseUrl = 'http://localhost:8080/api';

  /**
   * @constructor
   * @param {HttpClient} http - Экземпляр HttpClient для выполнения HTTP запросов
   */
  constructor(private http: HttpClient) {}

  /**
   * @summary Получение списка поставщиков
   * @description Делает запрос к API для получения списка всех поставщиков
   * @returns {Promise<Supplier[]>} Обещание, содержащее массив поставщиков
   */
  async getSuppliers() : Promise<any> {
    let a =  await this.http.get<Supplier[]>(`${this.baseUrl}/suppliers`).toPromise();
    console.log(a);
    return a;
  }

  /**
   * @summary Получение списка продуктов
   * @description Делает запрос к API для получения списка всех продуктов
   * @returns {Promise<Product[]>} Обещание, содержащее массив продуктов
   */
  async getProducts(): Promise<any> {
    let a =  await this.http.get<Product[]>(`${this.baseUrl}/products`).toPromise();
    console.log(a);
    return a;
  }
  /**
   * @summary Отправка данных о поставках
   * @description Отправляет данные о поставках на сервер в виде списка объектов ProductSupply
   * @param {ProductSupply[]} productSupplyList - Список объектов ProductSupply для отправки
   * @returns {Promise<void>} Обещание, указывающее на завершение операции
   */
  async submitSupply (productSupplyList: ProductSupply[]){
    let productSupplyDTOs = productSupplyList.map(el => new SupplyDTO(el.supplier.id, el.product.id, el.quantity, el.supplyDate));
    await this.http.post(`${this.baseUrl}/supplies/list`, productSupplyDTOs).toPromise();
  }
}
