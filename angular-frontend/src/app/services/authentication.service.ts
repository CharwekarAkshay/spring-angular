import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  baseUrl: string = 'api/';

  constructor(private http: HttpClient) { }

  login(username: String, password: String): Observable<Boolean> {
    return this.http.post(this.baseUrl + 'users/login', {
      username,
      password,
    }).pipe(
      map((result: any) => {
        localStorage.setItem('access_token', result['jwt']);
        return true;
      })
    );
  }
}
