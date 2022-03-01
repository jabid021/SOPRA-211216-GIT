import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { AutreComponent } from './autre/autre.component';
import { BoldComponent } from './exercice-component/bold/bold.component';
import { BoldElementComponent } from './exercice-component/bold-element/bold-element.component';
import { TooltipComponent } from './exercice-component/tooltip/tooltip.component';

@NgModule({
  declarations: [AppComponent, DemoComponent, AutreComponent, BoldComponent, BoldElementComponent, TooltipComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
