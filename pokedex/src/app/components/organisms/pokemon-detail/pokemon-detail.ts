import { Component, Input, Output, EventEmitter } from '@angular/core';
import { NgIf, NgFor, UpperCasePipe, DecimalPipe } from '@angular/common';
import { PokemonSprite } from '../../atoms/pokemon-sprite/pokemon-sprite';
import { PokemonTypeBadge } from '../../atoms/pokemon-type-badge/pokemon-type-badge';
import { PokemonStats } from '../../molecules/pokemon-stats/pokemon-stats';
import { SearchBar } from '../../molecules/search-bar/search-bar';
import { PokemonDto } from '../../../core/models/pokemon.dto';

@Component({
  selector: 'app-pokemon-detail',
  imports: [NgIf, NgFor, UpperCasePipe, DecimalPipe, PokemonSprite, PokemonTypeBadge, PokemonStats, SearchBar],
  templateUrl: './pokemon-detail.html',
  styleUrl: './pokemon-detail.css'
})
export class PokemonDetail {
  @Input() pokemon: PokemonDto | null = null;
  @Output() searched = new EventEmitter<string>();
}