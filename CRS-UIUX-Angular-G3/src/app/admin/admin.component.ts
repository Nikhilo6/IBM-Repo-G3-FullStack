import { Component, OnInit } from '@angular/core';
import { AdminClass } from '../admin';
import { AssignprofService } from '../assignprof/assignprof.service';
import { AdminService } from './admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  constructor(private _httpService: AdminService ) { }
  ngOnInit(): void {
  }
  
}
