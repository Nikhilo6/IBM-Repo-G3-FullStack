import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NewuserComponent } from './newuser/newuser.component';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { DeletecourseComponent } from './deletecourse/deletecourse.component';
import { StudentapprovalComponent } from './studentapproval/studentapproval.component';
import { AddprofComponent } from './addprof/addprof.component';
import { AssignprofComponent } from './assignprof/assignprof.component';
import { PasswordComponent } from './password/password.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AdminComponent,
    NewuserComponent,
    AddcourseComponent,
    DeletecourseComponent,
    StudentapprovalComponent,
    AddprofComponent,
    AssignprofComponent,
    PasswordComponent,
    PagenotfoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
