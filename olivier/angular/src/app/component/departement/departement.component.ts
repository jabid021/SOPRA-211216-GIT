import { Departement } from './../../model/departement';
import { DepartementPersoService } from './../../service/departement-perso.service';
import { DepartementService } from './../../service/departement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-departement',
  templateUrl: './departement.component.html',
  styleUrls: ['./departement.component.css'],
  providers: [{ useClass: DepartementService, provide: DepartementService }],
})
export class DepartementComponent implements OnInit {
  constructor(private departementService: DepartementService) {}

  departements: Departement[] = [];

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.departementService.getAll().subscribe((result) => {
      this.departements = result;
    });
  }

  delete(id: number) {
    this.departementService.delete(id).subscribe((result) => {
      this.list();
    });
  }
}
