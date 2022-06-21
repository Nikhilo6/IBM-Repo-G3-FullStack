import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NewUser } from './newuser';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  newUserRegis(user : NewUser): Observable<any>{
    let getNewUser:string = "http://localhost:8080/user/newuser";
    return this.httpClient.post(`${getNewUser}/${user.role}/${user.user_id}/${user.user_name}/${user.user_password}`,{headers: this.headers});
  }
}
