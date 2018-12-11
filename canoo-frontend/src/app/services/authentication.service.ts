import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string) {
    return this.http.post('//localhost:8080/login',
      {
        username,
        password
      })
      .pipe(map((user: any) => {
        if (user) {
          user.authdata = btoa(username + ':' + password);
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
        return user;
      }));
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

  isAuthenticated() {
    return !!localStorage.getItem('currentUser');
  }

  isAdmin() {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    return currentUser && currentUser['userRole'] === 'Admin';
  }
}
