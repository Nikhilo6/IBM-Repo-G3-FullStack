import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';
@Injectable({
  providedIn: 'root'
})
export class AddService {
  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  addCourse(ad : AdminClass): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/addcourse";
    return this.httpClient.post(`${getStudentUrl}/${ad.course_name}/${ad.course_id}`,{headers: this.headers});
  }
}
