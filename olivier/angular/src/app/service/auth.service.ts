import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  public checkUsername(username: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/boot/api/auth/search/' + username
    );
  }
}
