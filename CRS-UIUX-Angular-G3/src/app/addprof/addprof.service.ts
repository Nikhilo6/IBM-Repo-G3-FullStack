import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class AddprofService {
  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  addProfessor(ad : AdminClass): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/addprof";
    return this.httpClient.post(`${getStudentUrl}/${ad.prof_id}/${ad.prof_name}`,{headers: this.headers});
  }

}
