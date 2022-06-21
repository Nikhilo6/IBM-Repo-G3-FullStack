import { Component, OnInit } from '@angular/core';
import { AdminClass } from '../admin';
import { AddService } from './add.service';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  newuser = new AdminClass();
  constructor(private _httpService: AddService ) { }
  
  ngOnInit(): void {
  }

  add_course(){
    this._httpService.addCourse(this.newuser).subscribe((res)=>{
             console.log(res);
             alert(res.message);  
  });
  }


}
