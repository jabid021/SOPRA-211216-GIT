import { DepartementService } from './../../service/departement.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from './../../model/departement';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-departement-edit',
  templateUrl: './departement-edit.component.html',
  styleUrls: ['./departement-edit.component.css'],
})
export class DepartementEditComponent implements OnInit {
  departement: Departement = new Departement();

  constructor(
    private activatedRoute: ActivatedRoute,
    private departementService: DepartementService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.departementService.get(params['id']).subscribe((result) => {
          this.departement = result;
        });
      }
    });
  }

  save() {
    if (this.departement.id) {
      //creation requete put
      this.departementService.update(this.departement).subscribe((ok) => {
        this.goList();
      });
    } else {
      //update requete put
      this.departementService.create(this.departement).subscribe((ok) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigate(['/departement']);
  }
}
