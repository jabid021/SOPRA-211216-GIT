import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DepartementPersoService {
  constructor() {}

  public getAll(): any[] {
    return [
      { nom: 'info', id: 1 },
      { id: 2, nom: 'direction' },
    ];
  }
}
