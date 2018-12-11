import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BookListComponent} from './book-list/book-list.component';
import {BookEditComponent} from './book-edit/book-edit.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './helpers/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/book-list', pathMatch: 'full' },
  { path: 'book-list', component: BookListComponent, canActivate: [AuthGuard] },
  { path: 'book-add', component: BookEditComponent, canActivate: [AuthGuard] },
  { path: 'book-edit/:id', component: BookEditComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
