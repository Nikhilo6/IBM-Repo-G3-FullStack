import { Component, OnInit } from '@angular/core';
import { AdminClass } from '../admin';
import { AssignprofService } from './assignprof.service';

@Component({
  selector: 'app-assignprof',
  templateUrl: './assignprof.component.html',
  styleUrls: ['./assignprof.component.css']
})
export class AssignprofComponent implements OnInit {

  user = new AdminClass();
  constructor(private _httpService: AssignprofService ) { }

  ngOnInit(): void {
  }
  assign_course(){
    this._httpService.assignCourse(this.user).subscribe((res : any)=>{
             console.log(res);
             alert(res.message);
  });
  }
}
