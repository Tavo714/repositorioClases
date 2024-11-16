import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PedidosData } from '../Models/pedidos-data';
import { PedidosSearchFilter } from '../Models/pedidos-search-filter';
import { PedidosPage } from '../Models/pedidos-page';


@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  apiUrlBasePath = "http://localhost:8080/api/v1/";
  httpOptions;


  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders(
        {
          //'Authorization': 'Basic R2FicmllbDoxMjM=',
          'Content-Type': 'application/json'
        }
      )
    }
  }
    getById(id: string): Observable<PedidosData>{
      return this.httpClient.get<PedidosData>(`${this.apiUrlBasePath}pedidos/${id}`,this.httpOptions);
    }
    getAllPageable(filter: PedidosSearchFilter):Observable<PedidosPage>{
      let filterparams = new HttpParams()
      .set('pageNumber', filter.pageNumber)
      .set('pageSize', filter.pageSize)
      .set('columnOrder', filter.columnOrder)
      .set('direction', filter.direction)
      .set('filter', filter.filter)
      
      return this.httpClient.get<PedidosPage>(`${this.apiUrlBasePath}pedidos/page`, {params: filterparams, headers:this.httpOptions.headers});
    }
    create(pedidos: PedidosData):Observable<PedidosData>{ 
      return this.httpClient.post<PedidosData>(`${this.apiUrlBasePath}pedidos`, pedidos,this.httpOptions);

    }
    update(pedidos: PedidosData):Observable<PedidosData>{
      return this.httpClient.put<PedidosData>(`${this.apiUrlBasePath}pedidos/${pedidos.pedidoId}`, pedidos, this.httpOptions);
    }
    delete(id: number){
      return this.httpClient.delete(`${this.apiUrlBasePath}pedidos/${id}`, {responseType: 'text', headers:this.httpOptions.headers});
    
   }
  
   
}
