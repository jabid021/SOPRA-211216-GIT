import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {
    console.log('creation du service');
  }

  public sayHello(): string {
    return 'hello du service';
  }
}
