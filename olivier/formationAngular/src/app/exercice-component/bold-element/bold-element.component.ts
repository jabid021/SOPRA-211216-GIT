import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-bold-element',
  templateUrl: './bold-element.component.html',
  styleUrls: ['./bold-element.component.css'],
})
export class BoldElementComponent implements OnInit {
  @Input()
  prefix: string = '';
  @Input()
  text: string = '';

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  click() {
    alert(this.text);
  }
}
