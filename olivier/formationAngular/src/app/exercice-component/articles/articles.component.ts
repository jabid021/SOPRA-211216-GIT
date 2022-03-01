import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css'],
})
export class ArticlesComponent implements OnInit {
  nomArticlePopulaire = '';
  likeArticlePopulaire = 0;

  constructor() {}

  ngOnInit(): void {}

  traitementLike(obj: any) {
    if (obj.like > this.likeArticlePopulaire) {
      this.nomArticlePopulaire = obj.nom;
      this.likeArticlePopulaire = obj.like;
    }
  }
}
