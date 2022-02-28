import { Produit } from './../model/produit';
import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'demo,[autreDemo]',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css'],
})
export class DemoComponent implements OnInit {
  @Input('param')
  prenom: string = '';

  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  click() {
    console.log('click');
  }
}
