import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DisplayallComponent } from './components/displayall/displayall.component';
import { AddplayerComponent } from './components/addplayer/addplayer.component';
import { UpdateplayerComponent } from './components/updateplayer/updateplayer.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    DisplayallComponent,
    AddplayerComponent,
    UpdateplayerComponent,
    SearchComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
