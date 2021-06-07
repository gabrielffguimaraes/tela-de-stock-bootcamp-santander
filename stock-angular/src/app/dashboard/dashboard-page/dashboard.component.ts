import { DashboardService } from './../dashboard.service';
import { Component, OnInit } from '@angular/core';
import { Stock } from 'src/app/shared/models/stock-model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  stocks: Stock[];
  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
      this.dashboardService.getStocks().then((data) => {
          this.stocks = data;
          console.log(data);
      });
  }

}
