import { Directive, ElementRef, Renderer2, OnInit } from '@angular/core';

@Directive({
  selector: '[btn-warning]',
})
export class WarningDirective implements OnInit {
  constructor(private el: ElementRef, private renderer: Renderer2) {}
  ngOnInit(): void {
    this.renderer.addClass(this.el.nativeElement, 'btn');
    this.renderer.addClass(this.el.nativeElement, 'btn-outline-warning');
  }
}
