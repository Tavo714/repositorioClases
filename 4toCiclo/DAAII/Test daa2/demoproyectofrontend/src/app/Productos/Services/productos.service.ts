import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductosData } from '../Models/productos-data';
import { ProductosSearchFilter } from '../Models/productos-search-filter';
import { ProductosPage } from '../Models/productos-page';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
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
    getById(id: string): Observable<ProductosData>{
      return this.httpClient.get<ProductosData>(`${this.apiUrlBasePath}productos/${id}`,this.httpOptions);
    }
    getAllPageable(filter: ProductosSearchFilter):Observable<ProductosPage>{
      let filterparams = new HttpParams()
      .set('pageNumber', filter.pageNumber)
      .set('pageSize', filter.pageSize)
      .set('columnOrder', filter.columnOrder)
      .set('direction', filter.direction)
      .set('filter', filter.filter)
      
      return this.httpClient.get<ProductosPage>(`${this.apiUrlBasePath}productos/page`, {params: filterparams, headers:this.httpOptions.headers});
    }
    create(productos: ProductosData):Observable<ProductosData>{ 
      return this.httpClient.post<ProductosData>(`${this.apiUrlBasePath}productos`, productos,this.httpOptions);

    }
    update(productos: ProductosData):Observable<ProductosData>{
      return this.httpClient.put<ProductosData>(`${this.apiUrlBasePath}productos/${productos.productoId}`, productos, this.httpOptions);
    }
    delete(id: number){
      return this.httpClient.delete(`${this.apiUrlBasePath}productos/${id}`, {responseType: 'text', headers:this.httpOptions.headers});
    
   }
  
   
}
