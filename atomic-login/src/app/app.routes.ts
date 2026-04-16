import { Routes } from '@angular/router';
import { LoginFormComponent } from './component/organisms/login-form/login-form';
import { RegisterFormComponent } from './component/organisms/register-form/register-form';
import { MenuDashboardComponent } from './component/organisms/menu-dashboard/menu-dashboard';
import { GamePageComponent } from './pages/game-page/game-page';
import { MundialPageComponent } from './pages/mundial-page/mundial-page';
import { CafeteriaPageComponent } from './pages/cafeteria-page/cafeteria-page';

export const routes: Routes = [
  { path: '', component: LoginFormComponent, title: 'Iniciar Sesión' },
  { path: 'register', component: RegisterFormComponent, title: 'Registrarse' },
  { path: 'menu', component: MenuDashboardComponent, title: 'Menú Principal' },
  { path: 'game', component: GamePageComponent, title: 'Game Arena' },
  { path: 'mundial', component: MundialPageComponent, title: 'Mundial' },
  { path: 'cafeteria', component: CafeteriaPageComponent, title: 'Cafetería' },
  { path: '**', redirectTo: '' }
];