import { Produit } from './../../model/produit';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css'],
})
export class OutputComponent implements OnInit {
  @Input()
  entree: string = '';

  @Output()
  sortie: EventEmitter<Produit> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  emit() {
    this.sortie.emit(new Produit('bd', 10));
  }
}
