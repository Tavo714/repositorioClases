import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClientesData } from '../Models/clientes-data';
import { ClientesSearchFilter } from '../Models/clientes-search-filter';
import { ClientesPage } from '../Models/clientes-page';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
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
    getById(id: string): Observable<ClientesData>{
      return this.httpClient.get<ClientesData>(`${this.apiUrlBasePath}clientes/${id}`,this.httpOptions);
    }
    
    getClientes(): Observable<ClientesData[]> {
      return this.httpClient.get<ClientesData[]>(`${this.apiUrlBasePath}clientes`, this.httpOptions);
    }
    getAllPageable(filter: ClientesSearchFilter):Observable<ClientesPage>{
      let filterparams = new HttpParams()
      .set('pageNumber', filter.pageNumber)
      .set('pageSize', filter.pageSize)
      .set('columnOrder', filter.columnOrder)
      .set('direction', filter.direction)
      .set('filter', filter.filter)
      
      return this.httpClient.get<ClientesPage>(`${this.apiUrlBasePath}clientes/page`, {params: filterparams, headers:this.httpOptions.headers});
    }
    create(cliente: ClientesData):Observable<ClientesData>{ 
      return this.httpClient.post<ClientesData>(`${this.apiUrlBasePath}clientes`, cliente,this.httpOptions);

    }
    update(cliente: ClientesData):Observable<ClientesData>{
      return this.httpClient.put<ClientesData>(`${this.apiUrlBasePath}clientes/${cliente.clienteId}`, cliente, this.httpOptions);
    }
    delet(id: number){
      return this.httpClient.delete(`${this.apiUrlBasePath}clientes/${id}`, {responseType: 'text', headers:this.httpOptions.headers});
    
   }
  
   
}
