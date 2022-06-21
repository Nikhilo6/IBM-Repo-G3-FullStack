import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  log_in(user : User): Observable<any>{
    let getUsertUrl:string = "http://localhost:8080/user/getusernamepassword";
    return this.httpClient.post(`${getUsertUrl}/${user.username}/${user.password}`,{headers: this.headers});
  }
}
