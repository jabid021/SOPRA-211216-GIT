import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-tooltip,[asc-tooltip]',
  templateUrl: './tooltip.component.html',
  styleUrls: ['./tooltip.component.css'],
})
export class TooltipComponent implements OnInit {
  @Input('asc-tooltip-titre')
  tooltip: string = '';
  visible = false;

  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseover')
  show() {
    this.visible = true;
  }

  @HostListener('mouseout')
  hide() {
    this.visible = false;
  }
}
