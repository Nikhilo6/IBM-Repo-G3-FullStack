import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class AssignprofService {


  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  assignCourse(ad : AdminClass): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/assigncourseprofessor";
    return this.httpClient.post(`${getStudentUrl}/${ad.prof_id}/${ad.course_id}`,{headers: this.headers});
  }
}
