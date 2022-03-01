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
  sortie: EventEmitter<any> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  emit() {
    this.sortie.emit({
      nom: 'un produit en json',
      prix: 20,
    });
  }
}
