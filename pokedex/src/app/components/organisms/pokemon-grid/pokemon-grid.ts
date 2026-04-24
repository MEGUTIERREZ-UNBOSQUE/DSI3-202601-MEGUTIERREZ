import { Component, Input, Output, EventEmitter } from '@angular/core';
import { NgFor } from '@angular/common';
import { PokemonCard } from '../../molecules/pokemon-card/pokemon-card';
import { PokemonDto } from '../../../core/models/pokemon.dto';

@Component({
  selector: 'app-pokemon-grid',
  imports: [NgFor, PokemonCard],
  templateUrl: './pokemon-grid.html',
  styleUrl: './pokemon-grid.css'
})
export class PokemonGrid {
  @Input() pokemons: PokemonDto[] = [];
  @Output() selected = new EventEmitter<PokemonDto>();
  @Output() next = new EventEmitter<void>();
  @Output() prev = new EventEmitter<void>();
}