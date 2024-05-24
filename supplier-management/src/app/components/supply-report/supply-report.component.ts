import { Component, OnInit } from '@angular/core';
import {SupplyService} from "../../services/supply.service";


@Component({
  selector: 'app-supply-report',
  templateUrl: './supply-report.component.html',
  styleUrls: ['./supply-report.component.css']
})
export class SupplyReportComponent implements OnInit {
  supplyReport: any[] = [];

  constructor(private supplyService: SupplyService) { }

  ngOnInit(): void {
    // this.loadSupplyReport();
  }

  loadSupplyReport() {
  }
}
