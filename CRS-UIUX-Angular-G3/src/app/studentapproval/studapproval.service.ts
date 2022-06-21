import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';

@Injectable({
  providedIn: 'root'
})
export class StudapprovalService {

  constructor(private httpClient:HttpClient) { }
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');


  ngOnInit(): void {
  }
  studentApproval(ad : AdminClass): Observable<any>{
    let getStudentUrl:string = "http://localhost:8080/admin/studentapproval";
    return this.httpClient.post(`${getStudentUrl}/${ad.stud_id}`,{headers: this.headers});
  }

}
