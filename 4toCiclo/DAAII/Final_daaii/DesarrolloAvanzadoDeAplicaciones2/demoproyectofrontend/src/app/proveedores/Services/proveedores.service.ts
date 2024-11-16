import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProveedoresData } from '../Models/proveedores-data';
import { ProveedoresSearchFilter } from '../Models/proveedores-search-filter';
import { ProveedoresPage } from '../Models/proveedores-page';

@Injectable({
  providedIn: 'root'
})
export class ProveedoresService {
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
    getById(id: string): Observable<ProveedoresData>{
      return this.httpClient.get<ProveedoresData>(`${this.apiUrlBasePath}proveedores/${id}`,this.httpOptions);
    }
    
    getClientes(): Observable<ProveedoresData[]> {
      return this.httpClient.get<ProveedoresData[]>(`${this.apiUrlBasePath}proveedores`, this.httpOptions);
    }
    getAllPageable(filter: ProveedoresSearchFilter):Observable<ProveedoresPage>{
      let filterparams = new HttpParams()
      .set('pageNumber', filter.pageNumber)
      .set('pageSize', filter.pageSize)
      .set('columnOrder', filter.columnOrder)
      .set('direction', filter.direction)
      .set('filter', filter.filter)
      
      return this.httpClient.get<ProveedoresPage>(`${this.apiUrlBasePath}proveedores/page`, {params: filterparams, headers:this.httpOptions.headers});
    }
    create(proveedores: ProveedoresData):Observable<ProveedoresData>{ 
      return this.httpClient.post<ProveedoresData>(`${this.apiUrlBasePath}proveedores`, proveedores,this.httpOptions);

    }
    update(proveedores: ProveedoresData):Observable<ProveedoresData>{
      return this.httpClient.put<ProveedoresData>(`${this.apiUrlBasePath}proveedores/${proveedores.proveedorId}`, proveedores, this.httpOptions);
    }
    delete(id: number){
      return this.httpClient.delete(`${this.apiUrlBasePath}proveedores/${id}`, {responseType: 'text', headers:this.httpOptions.headers});
    
   }
  
   
}
