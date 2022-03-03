import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-pilote-par-template',
  templateUrl: './formulaire-pilote-par-template.component.html',
  styleUrls: ['./formulaire-pilote-par-template.component.css'],
})
export class FormulairePiloteParTemplateComponent implements OnInit {
  prenom: string = '';
  nom: string = '';

  constructor() {}

  ngOnInit(): void {}

  submit(form: any) {
    if (form.valid) {
    }

    //touched   untouched
    //dirty     pristine
    //valid     invalid
    //s'applique à un control
    //formgroup(control,control)
  }
}
