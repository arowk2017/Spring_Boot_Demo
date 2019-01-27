import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplyformComponent } from './applyform/applyform.component';

const routes: Routes = [

  { path: '', component: ApplyformComponent },
  
  { path: '**',    redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
