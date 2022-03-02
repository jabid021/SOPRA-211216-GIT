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

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    BonjourComponent,
    FormBonjourComponent,
    NotFoundComponent,
    PuissancePipe,
    DepartementComponent,
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes), FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
