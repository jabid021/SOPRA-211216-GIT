import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-bonjour',
  templateUrl: './form-bonjour.component.html',
  styleUrls: ['./form-bonjour.component.css'],
})
export class FormBonjourComponent implements OnInit {
  nom: string = '';
  erreur = false;

  constructor(private router: Router) {}

  ngOnInit(): void {}

  validationNom() {
    if (this.nom) {
      this.router.navigate(['/bonjour', this.nom]);
      this.erreur = false;
    } else {
      this.erreur = true;
    }
  }
}
