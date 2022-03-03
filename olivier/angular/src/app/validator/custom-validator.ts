import { Observable } from 'rxjs';
import {
  AbstractControl,
  ValidationErrors,
  ValidatorFn,
  FormGroup,
  AsyncValidatorFn,
} from '@angular/forms';

export class CustomValidator {
  public static pasToto(control: AbstractControl): ValidationErrors | null {
    return control.value == 'toto' ? { pasToto: true } : null;
  }

  public static pasTexteDefini(texte: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == texte ? { pasTexte: true } : null;
    };
  }

  public static egalite(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    if (formGroup.controls['zone1'].pristine) return null;
    return formGroup.controls['zone1'].value !=
      formGroup.controls['zone2'].value
      ? { egalite: true }
      : null;
  }
}
