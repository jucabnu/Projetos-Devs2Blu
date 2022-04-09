import { DetailCardComponent } from './components/detail-card/detail-card.component';
import { ListCardComponent } from './components/list-card/list-card.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'cards', component: ListCardComponent},
  {path: 'card/:id', component: DetailCardComponent},
  {path: '', redirectTo: '/cards', pathMatch: 'full'}
  // {path: 'setcard', component: ListCardsetComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
