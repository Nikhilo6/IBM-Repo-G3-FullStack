import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class DeleteService {

  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  deleteCourse(us : AdminClass): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/deletecourse";
    return this.httpClient.post(`${getStudentUrl}/${us.course_id}`,{headers: this.headers});
  }

}

