import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {ReportService} from "../../services/report.service";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatDatepicker, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatInput} from "@angular/material/input";
import {Supply} from "../models/Supply";
import {SupplyHolder} from "../models/SupplyHolder";
/**
 * Компонент для отображения отчета по поставкам.
 * Отображает форму для выбора периода и таблицу с данными о поставках.
 */
@Component({
  selector: 'app-supply-report',
  templateUrl: './supply-report.component.html',
  imports: [CommonModule, FormsModule, MatLabel, MatDatepickerToggle, MatFormField, MatDatepicker, MatInput],
  standalone: true,
  styleUrls: ['./supply-report.component.css']
})
export class SupplyReportComponent  implements OnInit {
  startDate: Date = new Date();
  endDate:Date = new Date();
  reportData!: SupplyHolder[];


  /**
   * Конструктор компонента.
   * @param reportService Сервис для работы с отчетами.
   */
  constructor(protected reportService: ReportService) {}

  /**
   * Инициализация компонента.
   */
  async ngOnInit() {
  }

  /**
   * Генерирует отчет за выбранный период.
   */
  async generateReport() {
    this.reportData = await this.reportService.generateReport(this.startDate, this.endDate).then(r => this.reportData = r);
  }
}
