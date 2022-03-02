import { Departement } from './../model/departement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DepartementService {
  static URL: string = 'http://localhost:8080/boot/api/departement';
  constructor(private http: HttpClient) {}

  get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('olivier:olivier'),
    });
  }

  getAll(): Observable<Departement[]> {
    return this.http.get<Departement[]>(DepartementService.URL, {
      headers: this.httpHeaders,
    });
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(DepartementService.URL + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  get(id: number): Observable<Departement> {
    return this.http.get<Departement>(DepartementService.URL + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  update(departement: Departement): Observable<Departement> {
    return this.http.put<Departement>(
      DepartementService.URL + '/' + departement.id,
      departement,
      {
        headers: this.httpHeaders,
      }
    );
  }

  create(departement: Departement): Observable<Departement> {
    const departementEnJson = { nom: departement.nom };
    return this.http.post<Departement>(
      DepartementService.URL,
      departementEnJson,
      {
        headers: this.httpHeaders,
      }
    );
  }
}
