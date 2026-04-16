import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-game-arena',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './game-arena.html',
  styleUrl: './game-arena.css'
})
export class GameArenaComponent {
  elements: number = 0;
  selections: string[] = [];
  winner: string = '';

  generateElements(value: number): void {
    this.elements = value;
    this.winner = '';
    this.selections = new Array(this.elements).fill('');
  }

  calculateWinner(): void {
    let alice = 0, bob = 0, tie = 0;

    for (let game of this.selections) {
      if (game === 'Alice') alice++;
      else if (game === 'Bob') bob++;
      else if (game === 'Empate') tie++;
    }

    if (alice > bob) this.winner = `ALICE (${alice} PUNTOS)`;
    else if (bob > alice) this.winner = `BOB (${bob} PUNTOS)`;
    else this.winner = `EMPATE (${tie} PARTIDAS)`;
  }
}