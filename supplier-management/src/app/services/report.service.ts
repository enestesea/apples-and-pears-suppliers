import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {SupplyHolder} from "../components/models/SupplyHolder";

/**
 * @summary Сервис для генерации отчетов
 * @description Этот сервис предоставляет методы для генерации отчетов на основе данных о поставках
 */
@Injectable({
  providedIn: 'root'
})
export class ReportService {
  /** Базовый URL для API запросов */
  private baseUrl = 'http://localhost:8080/api';

  /**
   * @constructor
   * @param {HttpClient} http - Экземпляр HttpClient для выполнения HTTP запросов
   */
  constructor(private http: HttpClient) {}

  /**
   * @summary Генерация отчета
   * @description Генерирует отчет за указанный период времени, делая запрос к API и возвращая данные о поставках
   * @param {any} startDate - Дата начала периода
   * @param {any} endDate - Дата конца периода
   * @returns {Promise<any>} Обещание, содержащее данные отчета
   * @throws {Error} Если формат даты недействителен
   */
  async generateReport(startDate: any, endDate: any): Promise<any> {
    const start = new Date(startDate);
    const end = new Date(endDate);

    if (isNaN(start.getTime()) || isNaN(end.getTime())) {
      throw new Error('Invalid date format');
    }

    const params = new HttpParams()
      .set('startDate', start.toDateString())
      .set('endDate', end.toDateString());

    let a = await this.http.get<SupplyHolder[]>(`${this.baseUrl}/supplies/report`, {params}).toPromise();
    console.log(a);
    return a;
  }
}
