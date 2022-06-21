import { Component, OnInit } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  public message = "ID Not Found. Try Again with correct ID and Password.";
  user = new User();
  constructor(private _httpService: UserService, private router: Router ) { }

  ngOnInit(): void {
  }

  login(){

    this._httpService.log_in(this.user).subscribe((res : any)=>{
             console.log(res.message);
             if (res.message == 'true'){
                this.router.navigate(['admin']);
             }
             else if(res.message == 'false'){
              alert(this.message);
             }
  });
  }

}
