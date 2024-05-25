import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { SupplyReportComponent } from './components/supply-report/supply-report.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {SupplyEntryComponent} from "./components/supply-entry/supply-entry.component";

@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SupplyEntryComponent,
    AppComponent
  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
