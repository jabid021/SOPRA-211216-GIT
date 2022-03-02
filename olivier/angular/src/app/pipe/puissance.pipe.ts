import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'puissance',
})
export class PuissancePipe implements PipeTransform {
  transform(value: number, puissance = 1): number {
    return Math.pow(value, puissance);
  }
}
