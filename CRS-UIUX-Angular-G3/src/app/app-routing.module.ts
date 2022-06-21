import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { AddprofComponent } from './addprof/addprof.component';
import { AdminComponent } from './admin/admin.component';
import { AssignprofComponent } from './assignprof/assignprof.component';
import { DeletecourseComponent } from './deletecourse/deletecourse.component';
import { NewuserComponent } from './newuser/newuser.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { PasswordComponent } from './password/password.component';
import { StudentapprovalComponent } from './studentapproval/studentapproval.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [

  { path: '', redirectTo: 'user', pathMatch: 'full'},
{ path: 'user', component:  UserComponent },
{ path: 'new_reg', component: NewuserComponent },
{ path: 'admin', component:  AdminComponent},
{ path : 'add', component:  AddcourseComponent},
{ path : 'delete', component:  DeletecourseComponent},
{ path : 'approval', component:  StudentapprovalComponent},
{ path : 'addprof', component:  AddprofComponent},
{ path : 'assignprof', component:  AssignprofComponent},
{ path : 'pw', component:  PasswordComponent},
{ path : '**', component:  PagenotfoundComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
