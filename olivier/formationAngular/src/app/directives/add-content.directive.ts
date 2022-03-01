import { Directive, ElementRef, Renderer2, OnInit, Input } from '@angular/core';

@Directive({
  selector: '[add-content]',
})
export class AddContentDirective implements OnInit {
  @Input()
  message: string = '';

  constructor(private elmRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    const p = this.renderer.createElement('p');
    const text = this.renderer.createText(
      'du texte cree par la directive avec le message recu:' + this.message
    );
    this.renderer.appendChild(p, text);
    this.renderer.appendChild(this.elmRef.nativeElement, p);
  }
}
