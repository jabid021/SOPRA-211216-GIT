import { NotFoundComponent } from './component/not-found/not-found.component';
import { BonjourComponent } from './component/bonjour/bonjour.component';
import { AcceuilComponent } from './component/acceuil/acceuil.component';
import { Routes } from '@angular/router';
import { FormBonjourComponent } from './component/form-bonjour/form-bonjour.component';

export const routes: Routes = [
  { path: 'acceuil', component: AcceuilComponent },
  { path: 'bonjour', component: FormBonjourComponent },
  { path: 'bonjour/:nom', component: BonjourComponent },
  { path: '', redirectTo: 'acceuil', pathMatch: 'full' },
  {
    path: '**',
    component: NotFoundComponent,
  },
];
