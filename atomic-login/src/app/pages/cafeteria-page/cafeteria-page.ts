import { Component } from '@angular/core';
import { CafeteriaArenaComponent } from '../../component/organisms/cafeteria-arena/cafeteria-arena';

@Component({
  selector: 'app-cafeteria-page',
  standalone: true,
  imports: [CafeteriaArenaComponent],
  templateUrl: './cafeteria-page.html',
  styleUrl: './cafeteria-page.css'
})
export class CafeteriaPageComponent {}