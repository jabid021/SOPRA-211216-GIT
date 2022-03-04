import { AuthenticationGuardService } from './service/authentication-guard.service';
import { LoginComponent } from './component/login/login.component';
import { InscriptionComponent } from './component/inscription/inscription.component';
import { FormulairePiloteParCodeComponent } from './formulaire/formulaire-pilote-par-code/formulaire-pilote-par-code.component';
import { FormulairePiloteParTemplateComponent } from './formulaire/formulaire-pilote-par-template/formulaire-pilote-par-template.component';
import { EditEmployeComponent } from './component/employe/edit-employe/edit-employe.component';
import { ListEmployeComponent } from './component/employe/list-employe/list-employe.component';
import { DepartementEditComponent } from './component/departement-edit/departement-edit.component';
import { DepartementComponent } from './component/departement/departement.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import { BonjourComponent } from './component/bonjour/bonjour.component';
import { AcceuilComponent } from './component/acceuil/acceuil.component';
import { Routes } from '@angular/router';
import { FormBonjourComponent } from './component/form-bonjour/form-bonjour.component';

export const routes: Routes = [
  { path: 'acceuil', component: AcceuilComponent },
  { path: 'bonjour', component: FormBonjourComponent },
  { path: 'bonjour/:nom', component: BonjourComponent },
  {
    path: 'departement',
    component: DepartementComponent,
    canActivate: [AuthenticationGuardService],
  },
  {
    path: 'departement/edit',
    component: DepartementEditComponent,
    canActivate: [AuthenticationGuardService],
  },
  {
    path: 'departement/edit/:id',
    component: DepartementEditComponent,
    canActivate: [AuthenticationGuardService],
  },
  {
    path: 'employe',
    component: ListEmployeComponent,
    canActivate: [AuthenticationGuardService],
  },
  {
    path: 'employe/edit',
    component: EditEmployeComponent,
    canActivate: [AuthenticationGuardService],
  },
  {
    path: 'employe/edit/:id',
    component: EditEmployeComponent,
    canActivate: [AuthenticationGuardService],
  },
  { path: 'form/template', component: FormulairePiloteParTemplateComponent },
  { path: 'form/code', component: FormulairePiloteParCodeComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'acceuil', pathMatch: 'full' },
  {
    path: '**',
    component: NotFoundComponent,
  },
];
