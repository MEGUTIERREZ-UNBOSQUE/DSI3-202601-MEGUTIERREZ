import { Component, Input, Output, EventEmitter } from '@angular/core';
import { NgFor } from '@angular/common';
import { PokemonSprite } from '../../atoms/pokemon-sprite/pokemon-sprite';
import { PokemonName } from '../../atoms/pokemon-name/pokemon-name';
import { PokemonTypeBadge } from '../../atoms/pokemon-type-badge/pokemon-type-badge';
import { PokemonDto } from '../../../core/models/pokemon.dto';

@Component({
  selector: 'app-pokemon-card',
  imports: [NgFor, PokemonSprite, PokemonName, PokemonTypeBadge],
  templateUrl: './pokemon-card.html',
  styleUrl: './pokemon-card.css'
})
export class PokemonCard {
  @Input() pokemon!: PokemonDto;
  @Output() selected = new EventEmitter<PokemonDto>();

  onSelect() {
    this.selected.emit(this.pokemon);
  }
}