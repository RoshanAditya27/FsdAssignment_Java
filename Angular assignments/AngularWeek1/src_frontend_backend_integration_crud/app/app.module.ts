import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DisplayallComponent } from './components/displayall/displayall.component';

import { AddemployeeComponent } from './components/addemployee/addemployee.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SearchComponent } from './components/search/search.component';
import { UpdateemployeeComponent } from './components/updateemployee/updateemployee.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayallComponent,
    AddemployeeComponent,
    DashboardComponent,
    SearchComponent,
    UpdateemployeeComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
