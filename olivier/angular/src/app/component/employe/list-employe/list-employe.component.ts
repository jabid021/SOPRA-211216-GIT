import { Observable } from 'rxjs';
import { EmployeService } from './../../../service/employe.service';
import { Component, OnInit } from '@angular/core';
import { Employe } from 'src/app/model/employe';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

@Component({
  selector: 'app-list-employe',
  templateUrl: './list-employe.component.html',
  styleUrls: ['./list-employe.component.css'],
})
export class ListEmployeComponent implements OnInit {
  employesObservable!: Observable<Employe[]>;

  constructor(private employeService: EmployeService) {}

  ngOnInit(): void {
    this.employesObservable = this.employeService.getAll();
  }

  delete(id: number) {
    this.employeService.delete(id).subscribe((ok) => {
      this.employesObservable = this.employeService.getAll();
    });
  }
}
