import { Component, OnInit } from '@angular/core';
import { NewUser } from './newuser';
import { UserService } from './user.service';

@Component({
  selector: 'app-newuser',
  templateUrl: './newuser.component.html',
  styleUrls: ['./newuser.component.css']
})
export class NewuserComponent implements OnInit {

  newuser = new NewUser();
  data = '';
  constructor(private _httpService: UserService ) { }

  ngOnInit(): void {
  }

  new_user(){
    this._httpService.newUserRegis(this.newuser).subscribe((res : any)=>{
             console.log(res);
             this.data = res;
             alert(res.message);
  });
  }

}
