import { DepartementService } from './../../service/departement.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-departement',
  templateUrl: './departement.component.html',
  styleUrls: ['./departement.component.css'],
})
export class DepartementComponent implements OnInit {
  constructor(private departementService: DepartementService) {}

  departements: any[] = [];

  ngOnInit(): void {
    this.departements = this.departementService.getAll();
  }
}
