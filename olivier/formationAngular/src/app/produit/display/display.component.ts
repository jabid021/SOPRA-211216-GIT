import { Produit } from './../../model/produit';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
})
export class DisplayComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}
}
