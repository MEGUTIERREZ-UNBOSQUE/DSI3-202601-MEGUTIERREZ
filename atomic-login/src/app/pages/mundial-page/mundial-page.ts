import { Component } from '@angular/core';
import { MundialArenaComponent } from '../../component/organisms/mundial-arena/mundial-arena';

@Component({
  selector: 'app-mundial-page',
  standalone: true,
  imports: [MundialArenaComponent],
  templateUrl: './mundial-page.html',
  styleUrl: './mundial-page.css'
})
export class MundialPageComponent {}