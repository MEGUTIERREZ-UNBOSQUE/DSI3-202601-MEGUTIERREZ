import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputNumberComponent } from '../../atoms/input-number/input-number';
import { MatchRowComponent } from '../../molecules/match-row/match-row';
import { WinnerDisplayComponent } from '../../molecules/winner-display/winner-display';
import { ButtomComponent } from '../../atoms/buttom/buttom';

@Component({
  selector: 'app-mundial-arena',
  standalone: true,
  imports: [
    CommonModule,
    InputNumberComponent,
    MatchRowComponent,
    WinnerDisplayComponent,
    ButtomComponent
  ],
  templateUrl: './mundial-arena.html',
  styleUrl: './mundial-arena.css'
})
export class MundialArenaComponent {
  quantity: number = 1;
  matches: { colombiaGoals: number; franciaGoals: number }[] = [];
  winner: string = '';

  generateMatches(): void {
    if (this.quantity < 1 || this.quantity > 100) return;
    this.winner = '';
    this.matches = Array.from({ length: this.quantity }, () => ({
      colombiaGoals: 0,
      franciaGoals: 0,
    }));
  }

  calculateWinner(): void {
    let colombiaMatches = 0;
    let franciaMatches = 0;
    let colombiaTotalGoals = 0;
    let franciaTotalGoals = 0;

    for (let match of this.matches) {
      colombiaTotalGoals += match.colombiaGoals;
      franciaTotalGoals += match.franciaGoals;

      if (match.colombiaGoals > match.franciaGoals) {
        colombiaMatches++;
      } else if (match.franciaGoals > match.colombiaGoals) {
        franciaMatches++;
      }
    }

    if (colombiaMatches > franciaMatches) {
      this.winner = `🇨🇴 Colombia (${colombiaMatches} partidos, ${colombiaTotalGoals} goles)`;
    } else if (franciaMatches > colombiaMatches) {
      this.winner = `🇫🇷 Francia (${franciaMatches} partidos, ${franciaTotalGoals} goles)`;
    } else {
      if (colombiaTotalGoals > franciaTotalGoals) {
        this.winner = `🇨🇴 Colombia por goles (${colombiaTotalGoals} vs ${franciaTotalGoals})`;
      } else if (franciaTotalGoals > colombiaTotalGoals) {
        this.winner = `🇫🇷 Francia por goles (${franciaTotalGoals} vs ${colombiaTotalGoals})`;
      } else {
        this.winner = `Empate total (${colombiaMatches} partidos, ${colombiaTotalGoals} goles c/u)`;
      }
    }
  }

  updateColombiaGoals(index: number, value: number): void {
    this.matches[index].colombiaGoals = value;
  }

  updateFranciaGoals(index: number, value: number): void {
    this.matches[index].franciaGoals = value;
  }
}