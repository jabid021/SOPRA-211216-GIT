import { ListComponent } from './produit/list/list.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { HelloComponent } from './route/hello/hello.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListComponent },
  { path: 'produits/list', component: ListComponent },
  { path: 'hello/:name', component: HelloComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
