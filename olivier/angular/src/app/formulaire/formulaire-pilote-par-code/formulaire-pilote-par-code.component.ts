import { AuthService } from './../../service/auth.service';
import { map, Observable } from 'rxjs';
import { CustomValidator } from './../../validator/custom-validator';
import { Component, OnInit } from '@angular/core';
import {
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';

@Component({
  selector: 'app-formulaire-pilote-par-code',
  templateUrl: './formulaire-pilote-par-code.component.html',
  styleUrls: ['./formulaire-pilote-par-code.component.css'],
})
export class FormulairePiloteParCodeComponent implements OnInit {
  monForm!: FormGroup;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.monForm = new FormGroup({
      prenomCtrl: new FormControl(
        '',
        [Validators.required, CustomValidator.pasToto],
        this.usernameExist()
      ),
      nomCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        CustomValidator.pasTexteDefini('tutu'),
      ]),
      group1: new FormGroup(
        {
          zone1: new FormControl(''),
          zone2: new FormControl(''),
        },
        CustomValidator.egalite
      ),
    });
  }

  submit() {
    // this.authService.checkUsername(this.monForm.controls['prenom'].value).subscribe(res=>{
    //   if(res){
    //     //traitement probleme
    //   }else{

    //   }
    // })
    console.log(this.monForm);
  }

  public usernameExist(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.authService.checkUsername(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { usernameExist: true } : null;
        })
      );
    };
  }
}
