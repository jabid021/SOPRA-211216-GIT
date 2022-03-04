import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AcceuilComponent } from './component/acceuil/acceuil.component';
import { BonjourComponent } from './component/bonjour/bonjour.component';
import { FormBonjourComponent } from './component/form-bonjour/form-bonjour.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import { routes } from './routes';
import { PuissancePipe } from './pipe/puissance.pipe';
import { DepartementComponent } from './component/departement/departement.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { DepartementEditComponent } from './component/departement-edit/departement-edit.component';
import { ListEmployeComponent } from './component/employe/list-employe/list-employe.component';
import { EditEmployeComponent } from './component/employe/edit-employe/edit-employe.component';
import { WarningDirective } from './directive/rendu/warning.directive';
import { FormulairePiloteParTemplateComponent } from './formulaire/formulaire-pilote-par-template/formulaire-pilote-par-template.component';
import { FormulairePiloteParCodeComponent } from './formulaire/formulaire-pilote-par-code/formulaire-pilote-par-code.component';
import { InscriptionComponent } from './component/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    BonjourComponent,
    FormBonjourComponent,
    NotFoundComponent,
    PuissancePipe,
    DepartementComponent,
    DepartementEditComponent,
    ListEmployeComponent,
    EditEmployeComponent,
    WarningDirective,
    FormulairePiloteParTemplateComponent,
    FormulairePiloteParCodeComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
