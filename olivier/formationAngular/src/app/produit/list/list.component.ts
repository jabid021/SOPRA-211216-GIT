import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  produits: Produit[] = [new Produit('tele', 1000), new Produit('bd', 10)];

  constructor() {}

  ngOnInit(): void {}

  infos(produit: Produit): string {
    if (produit.prix < 0) return 'negatif';
    else if (produit.prix == 0) {
      return 'neutre';
    } else {
      return 'positif';
    }
  }

  recuperationProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
