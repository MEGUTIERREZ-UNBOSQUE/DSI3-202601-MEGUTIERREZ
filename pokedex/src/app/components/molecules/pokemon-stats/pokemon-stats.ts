import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatBar } from '../../atoms/stat-bar/stat-bar';
import { PokemonDto } from '../../../core/models/pokemon.dto';

@Component({
  selector: 'app-pokemon-stats',
  standalone: true,
  imports: [CommonModule, StatBar],
  templateUrl: './pokemon-stats.html',
  styleUrl: './pokemon-stats.css'
})
export class PokemonStats {
  @Input() pokemon!: PokemonDto;

  getStatLabel(statName: string): string {
    const labels: Record<string, string> = {
      hp: 'HP',
      attack: 'ATK',
      defense: 'DEF',
      'special-attack': 'SPA',
      'special-defense': 'SPD',
      speed: 'SPE'
    };
    return labels[statName] || statName.slice(0, 3).toUpperCase();
  }
}