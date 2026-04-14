import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: 'game',
        loadComponent: () => import('./screens/game/game').then((m) => m.Game)
    },
    {
        path: 'mundial',
        loadComponent: () => import('./screens/mundial/mundial').then((m) => m.Mundial)
    },
    {
        path: '',
        redirectTo: 'game',
    }


];