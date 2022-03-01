import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css'],
})
export class ArticleComponent implements OnInit {
  @Input()
  titre: string = '';
  @Input()
  contenu: string = '';
  @Output()
  likeEvent: EventEmitter<any> = new EventEmitter();
  nbreLike = 0;

  constructor() {}

  ngOnInit(): void {}

  like() {
    this.nbreLike++;
    this.likeEvent.emit({
      nom: this.titre,
      like: this.nbreLike,
    });
  }
}
