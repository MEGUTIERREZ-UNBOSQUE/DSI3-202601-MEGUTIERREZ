import { Component } from '@angular/core';
import { GameArenaComponent } from '../../component/organisms/game-arena/game-arena';

@Component({
  selector: 'app-game-page',
  standalone: true,
  imports: [GameArenaComponent],
  template: `<app-game-arena></app-game-arena>`,
  styles: `:host { display: block; }`
})
export class GamePageComponent {}