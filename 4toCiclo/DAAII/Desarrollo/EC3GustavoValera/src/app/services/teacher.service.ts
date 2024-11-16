import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TeacherSearchFilter } from '../models/teacher-search-filter';
import { TeacherData } from '../models/teacher-data';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  apiUrlBasePath = "http://localhost:8080/api/v1/";
  httpOptions;

  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
   }

  getById(id: string): Observable<TeacherData>{
    return this.httpClient.get<TeacherData>(`${this.apiUrlBasePath}teachers/${id}`)
  }

  getAllPageable(filter: TeacherSearchFilter){
    let params = new HttpParams();
    params.append('pageNumber', filter.pageNumber);
    params.append('pageSize', filter.pageSize);
    params.append('column', filter.column);
    params.append('direction', filter.direction);
    return this.httpClient.get(`${this.apiUrlBasePath}teachers/page`, {params});
  }

  create(teacher: TeacherData): Observable<TeacherData>{
    return this.httpClient.post<TeacherData>(`${this.apiUrlBasePath}teachers`,teacher, this.httpOptions)
  }

  update(teacher: TeacherData): Observable<TeacherData>{
    return this.httpClient.post<TeacherData>(`${this.apiUrlBasePath}teachers`,teacher)
  }

  delete(id: number){
    return this.httpClient.delete(`${this.apiUrlBasePath}teachers/${id}`);
  }

}
