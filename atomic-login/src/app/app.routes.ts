import { Routes } from '@angular/router';
import { LoginFormComponent } from './component/organisms/login-form/login-form';
import { RegisterFormComponent } from './component/organisms/register-form/register-form';

export const routes: Routes = [
  {
    path: '',
    component: LoginFormComponent,
    title: 'Iniciar Sesión'
  },
  {
    path: 'register',
    component: RegisterFormComponent,
    title: 'Registrarse'
  },
  {
    path: '**',
    redirectTo: ''
  }
];