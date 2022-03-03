import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employe } from './../model/employe';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmployeService {
  private static URL = 'http://localhost:8080/boot/api/employe';

  constructor(private httpClient: HttpClient) {}

  get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('olivier:olivier'),
    });
  }

  public getAll(): Observable<Employe[]> {
    return this.httpClient.get<Employe[]>(EmployeService.URL, {
      headers: this.httpHeaders,
    });
  }

  public get(id: number): Observable<Employe> {
    return this.httpClient.get<Employe>(`${EmployeService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${EmployeService.URL}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public create(employe: Employe): Observable<Employe> {
    return this.httpClient.post<Employe>(
      EmployeService.URL,
      this.employeToJson(employe),
      {
        headers: this.httpHeaders,
      }
    );
  }

  public update(employe: Employe): Observable<Employe> {
    return this.httpClient.put<Employe>(
      `${EmployeService.URL}/${employe.id}`,
      this.employeToJson(employe),
      {
        headers: this.httpHeaders,
      }
    );
  }

  private employeToJson(employe: Employe): any {
    const obj = {
      id: employe.id,
      nom: employe.nom,
      salaire: employe.salaire,
      commission: employe.commission,
      dateEmbauche: employe.dateEmbauche,
      civilite: employe.civilite,
    };

    if (employe.adresse) {
      Object.assign(obj, {
        adresse: {
          numero: employe.adresse.numero,
          rue: employe.adresse.rue,
          codePostal: employe.adresse.codePostal,
          ville: employe.adresse.ville,
        },
      });
    }
    if (employe.departement) {
      Object.assign(obj, { departement: { id: employe.departement.id } });
    }
    return obj;
  }
}
