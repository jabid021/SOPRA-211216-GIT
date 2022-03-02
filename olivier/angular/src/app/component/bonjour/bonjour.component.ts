import { DemoService } from './../../service/demo.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'o',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  nom: string = '';

  constructor(
    private activatedRoute: ActivatedRoute,
    private demoService: DemoService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.nom = params['nom'];
    });
  }

  get messageDuService(): string {
    return this.demoService.sayHello();
  }
}
