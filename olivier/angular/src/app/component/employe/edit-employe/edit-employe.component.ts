import { Civilite } from './../../../model/civilite';
import { EmployeService } from './../../../service/employe.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employe } from './../../../model/employe';
import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/model/adresse';

@Component({
  selector: 'app-edit-employe',
  templateUrl: './edit-employe.component.html',
  styleUrls: ['./edit-employe.component.css'],
})
export class EditEmployeComponent implements OnInit {
  employe: Employe = new Employe();
  civilites = Civilite;

  constructor(
    private activatedRoute: ActivatedRoute,
    private employeService: EmployeService,
    private router: Router
  ) {
    this.employe.adresse = new Adresse();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.employeService.get(params['id']).subscribe((result) => {
          console.log(result);
          this.employe = result;
          if (!this.employe.adresse) {
            this.employe.adresse = new Adresse();
          }
        });
      }
    });
  }

  save() {
    if (this.employe.id) {
      this.employeService.update(this.employe).subscribe((ok) => {
        this.router.navigate(['/employe']);
      });
    } else {
      this.employeService.create(this.employe).subscribe((ok) => {
        this.router.navigate(['/employe']);
      });
    }
  }
}
