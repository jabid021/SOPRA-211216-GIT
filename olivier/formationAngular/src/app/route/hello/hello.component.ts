import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css'],
})
export class HelloComponent implements OnInit {
  name: string = 'world';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    // this.name = this.activatedRoute.snapshot.params['name'];
    this.activatedRoute.params.subscribe((params) => {
      this.name = params['name'];
    });
    //code execute avant la fin du traitement des parametres
  }

  goHello() {
    console.log('goHello');
    //traitement qui controle login/mot passe
    this.router.navigate(['/home']);
  }
}
