import { Component } from '@angular/core';
import { Produit } from './model/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  couleur = '#000000';

  unProduit(): Produit {
    return new Produit('tele', 1000);
  }
}
