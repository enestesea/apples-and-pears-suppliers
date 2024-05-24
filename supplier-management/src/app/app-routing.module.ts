// import {ApplicationConfig} from '@angular/core';
// import {provideRouter, Routes} from '@angular/router';
// import { SupplyEntryComponent } from './components/supply-entry/supply-entry.component';
// import { SupplyReportComponent } from './components/supply-report/supply-report.component';
// import {provideHttpClient} from "@angular/common/http";
//
// const routes: Routes = [
//   { path: 'supply-entry', component: SupplyEntryComponent },
//   { path: 'supply-report', component: SupplyReportComponent },
//   { path: '', redirectTo: '/supply-entry', pathMatch: 'full' }
// ];
//
// export const appConfig: ApplicationConfig = {
//   providers: [provideRouter(routes), provideHttpClient()]
// };
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SupplyEntryComponent } from './components/supply-entry/supply-entry.component';
import { SupplyReportComponent } from './components/supply-report/supply-report.component';

const routes: Routes = [
  { path: 'supply-entry', component: SupplyEntryComponent },
  { path: 'supply-report', component: SupplyReportComponent },
  { path: '', redirectTo: '/supply-entry', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
