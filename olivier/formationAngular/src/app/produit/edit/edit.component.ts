import { Produit } from './../../model/produit';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  produit: Produit = new Produit();

  @Output()
  produitReady: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  send() {
    this.produitReady.emit(this.produit);
    this.produit = new Produit();
  }
}
