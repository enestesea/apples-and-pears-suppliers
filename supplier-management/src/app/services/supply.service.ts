import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {Supplier} from "../components/models/Supplier";
import {Supply} from "../components/models/Supply";

@Injectable({
  providedIn: 'root',
})
export class SupplyService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }
  async getSuppliers() : Promise<any> {
    let a =  await this.http.get<Supplier[]>(`${this.baseUrl}/suppliers`).toPromise();
    console.log(a);
    return a;
  }
  // async getSuppliers(): Promise<any> {
  //   return this.http.get(`${this.baseUrl}/suppliers`);
  // }
  async getProducts(): Promise<any> {
    let a =  await this.http.get<Supplier[]>(`${this.baseUrl}/products`).toPromise();
    console.log(a);
    return a;  }

  async saveSupply(supply: Supply){

  }
  // getSupplies(): Observable<any> {
  //   return this.http.get(`${this.apiUrl}`);
  // }
  //
  // addSupply(supply: any): Observable<any> {
  //   return this.http.post(`${this.apiUrl}`, supply);
  // }
  // getSupplyReport() {
  //   return this.http.get<any[]>('/api/supply-report');
  // }
  //
  // getSuppliesByDateRange(startDate: string, endDate: string): Observable<any> {
  //   return this.http.get(`${this.apiUrl}/report`, {
  //     params: {
  //       startDate: startDate,
  //       endDate: endDate
  //     }
  //   });
  // }
}
