import { Component, Input } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { StatBar } from '../../atoms/stat-bar/stat-bar';
import { PokemonDto } from '../../../core/models/pokemon.dto';
@Component({
  selector: 'app-pokemon-stats',
  imports: [NgFor, NgIf, StatBar],
  templateUrl: './pokemon-stats.html',
  styleUrl: './pokemon-stats.css'
})
export class PokemonStats {
  @Input() pokemon!: PokemonDto;

  readonly statLabels: Record<string, string> = {
    hp: 'HP',
    attack: 'ATAQUE',
    defense: 'DEFENSA',
    speed: 'VELOCIDAD'
  };
}