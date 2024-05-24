import {provideRouter, Routes} from '@angular/router';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { SupplyEntryComponent } from './components/supply-entry/supply-entry.component';
import { SupplyReportComponent } from './components/supply-report/supply-report.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

const routes: Routes = [
  { path: 'supply-entry', component: SupplyEntryComponent },
  { path: 'supply-report', component: SupplyReportComponent },
  { path: '', redirectTo: '/supply-entry', pathMatch: 'full' }
];

export const appConfig = {
  providers: [
    provideRouter(routes),
    importProvidersFrom(HttpClientModule), provideAnimationsAsync()
  ]
};
