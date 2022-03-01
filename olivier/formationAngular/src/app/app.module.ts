import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoComponent } from './demo/demo.component';
import { AutreComponent } from './autre/autre.component';
import { BoldComponent } from './exercice-component/bold/bold.component';
import { BoldElementComponent } from './exercice-component/bold-element/bold-element.component';
import { TooltipComponent } from './exercice-component/tooltip/tooltip.component';
import { OutputComponent } from './demo/output/output.component';
import { EditComponent } from './produit/edit/edit.component';
import { DisplayComponent } from './produit/display/display.component';
import { ArticleComponent } from './exercice-component/article/article.component';
import { ArticlesComponent } from './exercice-component/articles/articles.component';
import { ListComponent } from './produit/list/list.component';
import { DemoDirective } from './directives/demo.directive';
import { AddContentDirective } from './directives/add-content.directive';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { HelloComponent } from './route/hello/hello.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    AutreComponent,
    BoldComponent,
    BoldElementComponent,
    TooltipComponent,
    OutputComponent,
    EditComponent,
    DisplayComponent,
    ArticleComponent,
    ArticlesComponent,
    ListComponent,
    DemoDirective,
    AddContentDirective,
    HelloComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
