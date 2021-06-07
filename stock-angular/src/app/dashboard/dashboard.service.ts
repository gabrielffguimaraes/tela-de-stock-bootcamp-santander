import { Injectable } from '@angular/core';
import { Stock } from '../shared/models/stock-model';
import { HttpClient} from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  readonly baseUrl = 'https://bootcamp-santander-stock-br.herokuapp.com/bootcamp/api';
  constructor(private http: HttpClient) { }

  async getStocks(): Promise<Stock[]> {
      return this.http.get<Stock[]>(`${this.baseUrl}/stock`).toPromise();
  }
}
