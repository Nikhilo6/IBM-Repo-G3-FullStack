import { Component, OnInit } from '@angular/core';
import { AdminClass } from '../admin';
import { AddprofService } from './addprof.service';

@Component({
  selector: 'app-addprof',
  templateUrl: './addprof.component.html',
  styleUrls: ['./addprof.component.css']
})
export class AddprofComponent implements OnInit {

  user = new AdminClass();
  constructor(private _httpService: AddprofService ) { }

  ngOnInit(): void {
  }

  add_professor(){
    this._httpService.addProfessor(this.user).subscribe((res : any)=>{
             console.log(res);
             alert(res.message);
  });
  }
}
