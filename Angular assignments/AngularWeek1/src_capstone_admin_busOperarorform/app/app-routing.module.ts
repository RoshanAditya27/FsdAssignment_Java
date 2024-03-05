import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { BusOperatorComponent } from './bus-operator/bus-operator.component';

const routes: Routes = [
  { path: 'admin', component: AppComponent },
  { path: 'bus-operator', component: BusOperatorComponent },
  { path: '', redirectTo: '/admin', pathMatch: 'full' }, // Default route to Admin component
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
