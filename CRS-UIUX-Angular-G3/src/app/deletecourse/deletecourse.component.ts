import { Component, OnInit } from '@angular/core';
import { AdminClass } from '../admin';
import { DeleteService } from './delete.service';

@Component({
  selector: 'app-deletecourse',
  templateUrl: './deletecourse.component.html',
  styleUrls: ['./deletecourse.component.css']
})
export class DeletecourseComponent implements OnInit {

  newuser = new AdminClass();
  constructor(private _httpService: DeleteService ) { }
  
  ngOnInit(): void {
  }

  delete_course(){
    this._httpService.deleteCourse(this.newuser).subscribe((res)=>{
             console.log(res); 
             alert(res.message); 
  });
  }
}
