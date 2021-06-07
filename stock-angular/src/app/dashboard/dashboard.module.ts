import { DashboardService } from './dashboard.service';
import { StockCardComponent } from './stock-card/stock-card.component';
import { SharedModule } from '../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard-page/dashboard.component';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    DashboardComponent,
    StockCardComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    HttpClientModule
  ],
  exports: [
    DashboardComponent,
    StockCardComponent
  ],
  providers: [
    DashboardService
  ]
})
export class DashboardModule { }
