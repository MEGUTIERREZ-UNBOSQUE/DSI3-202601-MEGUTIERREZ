import { Component, signal } from '@angular/core';
import { Game } from './screens/game/game';
import { Mundial } from './screens/mundial/mundial';

@Component({
  selector: 'app-root',
  imports: [
    Game,
      Mundial
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  options: number = 0;
  changeOptions(value: number): void {
    this.options = value;
    console.log(this.options);
  }
}

