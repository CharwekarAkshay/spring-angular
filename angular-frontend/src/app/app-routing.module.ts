import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { CanActivateService } from './guards/can-activate.service';

const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [CanActivateService], },
  { path: 'login', component: LoginComponent, },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
