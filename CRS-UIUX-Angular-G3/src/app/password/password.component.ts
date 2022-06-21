import { Component, OnInit } from '@angular/core';
import { Password } from './password';
import { PwService } from './pw.service';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {

  newuser = new Password();
  constructor(private _httpService: PwService ) { }
  
  ngOnInit(): void {
  }

  change_password(){
    this._httpService.pw_change(this.newuser).subscribe((res)=>{
             console.log(res);
             alert(res.message);  
  });
  }

}
