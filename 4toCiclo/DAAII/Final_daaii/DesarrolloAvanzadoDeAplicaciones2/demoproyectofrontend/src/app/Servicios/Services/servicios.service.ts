import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ServiciosData } from '../models/servicios-data';
import { ServiciosSearchFilter } from '../models/services-search-filter';
import { ServiciosPage } from '../models/services-page';

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {

  apiUrlBasePath = "http://localhost:8080/api/v1/";
  httpOptions;


  constructor(private httpService: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders(
        {
          //'Authorization': 'Basic R2FicmllbDoxMjM=',
          'Content-Type': 'application/json'
        }
      )
    }
  }
    getById(id: string): Observable<ServiciosData>{
      return this.httpService.get<ServiciosData>(`${this.apiUrlBasePath}servicios/${id}`,this.httpOptions);
    }
    getAllPageable(filter: ServiciosSearchFilter):Observable<ServiciosPage>{
      let filterparams = new HttpParams()
      .set('pageNumber', filter.pageNumber)
      .set('pageSize', filter.pageSize)
      .set('columnOrder', filter.columnOrder)
      .set('direction', filter.direction)
      .set('filter', filter.filter)
      
      return this.httpService.get<ServiciosPage>(`${this.apiUrlBasePath}servicios/page`, {params: filterparams, headers:this.httpOptions.headers});
    }
    create(servicios: ServiciosData):Observable<ServiciosData>{ 
      return this.httpService.post<ServiciosData>(`${this.apiUrlBasePath}servicios`, servicios,this.httpOptions);

    }
    update(servicios: ServiciosData):Observable<ServiciosData>{
      return this.httpService.put<ServiciosData>(`${this.apiUrlBasePath}servicios/${servicios.servicioId}`, servicios, this.httpOptions);
    }
    delete(id: number){
      return this.httpService.delete(`${this.apiUrlBasePath}servicios/${id}`, {responseType: 'text', headers:this.httpOptions.headers});
    
   }
  
   
}
