import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
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
import { HttpClientModule } from '@angular/common/http';
import { DepartementEditComponent } from './component/departement-edit/departement-edit.component';
import { ListEmployeComponent } from './component/employe/list-employe/list-employe.component';
import { EditEmployeComponent } from './component/employe/edit-employe/edit-employe.component';
import { WarningDirective } from './directive/rendu/warning.directive';

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
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
