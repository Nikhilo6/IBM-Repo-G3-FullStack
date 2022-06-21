import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminClass } from '../admin';
import { StudapprovalService } from './studapproval.service';

@Component({
  selector: 'app-studentapproval',
  templateUrl: './studentapproval.component.html',
  styleUrls: ['./studentapproval.component.css']
})
export class StudentapprovalComponent implements OnInit {

  user = new AdminClass();
  constructor(private _httpService: StudapprovalService ) { }
  ngOnInit(): void {
    
  }
  
  student_approval(){
    this._httpService.studentApproval(this.user).subscribe((res : any)=>{
             console.log(res);
             alert(res.message);
  });
  }
}
