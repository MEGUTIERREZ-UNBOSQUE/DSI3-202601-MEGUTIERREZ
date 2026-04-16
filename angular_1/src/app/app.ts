import { Component } from '@angular/core';
import { Game } from './screens/game/game';     
import { Mundial } from './screens/mundial/mundial'; 
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
  standalone: true,
  imports: [Game, Mundial, RouterOutlet]  
})
export class App {
  options: number = 1;  

  changeOptions(value: number): void { 
    this.options = value;
  }
}