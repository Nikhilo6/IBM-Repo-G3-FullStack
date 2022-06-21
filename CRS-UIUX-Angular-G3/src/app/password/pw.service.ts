import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Password } from './password';

@Injectable({
  providedIn: 'root'
})
export class PwService {

  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');

  pw_change(ad : Password): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/addcourse";
    return this.httpClient.post(`${getStudentUrl}/${ad.id}/${ad.pw}`,{headers: this.headers});
  }
}
