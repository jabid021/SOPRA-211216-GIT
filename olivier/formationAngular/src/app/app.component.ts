import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  binding = 'toto';

  couleur = 'Red';

  state = false;

  get hello(): string {
    return 'hello world';
  }

  methodeClick() {
    console.log('click');
    this.state = true;
  }

  methodePourCondition() {
    return this.state;
  }
}
