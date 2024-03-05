import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DisplayallComponent } from './components/displayall/displayall.component';
import { AddplayerComponent } from './components/addplayer/addplayer.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  { path: 'home', component: DashboardComponent },
  { path: 'addplayer', component: AddplayerComponent },
  { path: 'updateplayer', component: AddplayerComponent },
  { path: 'displayall', component: DisplayallComponent },
  { path: 'search/:input', component: SearchComponent }, // Define the route for the SearchComponent with a parameter ':input'
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
