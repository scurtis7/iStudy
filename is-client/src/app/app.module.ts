import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from "@angular/router";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FormsModule } from "@angular/forms";
import { MaterialModule } from "./common/material.module";
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MenuComponent } from './components/shared/menu/menu.component';
import { StudyTypesComponent } from './components/study-types/study-types.component';
import { HttpClientModule } from "@angular/common/http";

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'study-types', component: StudyTypesComponent },
  { path: '**', redirectTo: 'dashboard' }
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MenuComponent,
    StudyTypesComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MaterialModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
