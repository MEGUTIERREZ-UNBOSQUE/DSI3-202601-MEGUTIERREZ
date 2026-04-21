import { Component, inject } from '@angular/core';
import { NgFor } from '@angular/common';
import { PokemonService } from '../../core/services/pokemon';
import { PokemonDto } from '../../core/models/pokemon.dto';

@Component({
  selector: 'app-pokemon-page',
  imports: [NgFor],
  templateUrl: './pokemon-pages.html',
  styleUrl: './pokemon-pages.css'
})
export class PokemonPage {
  linksPokemon: PokemonDto[] = [];
  private pokemonService = inject(PokemonService);

  constructor() {
    this.pokemonService.getPokemons().subscribe(result => {
      this.linksPokemon = result;
      console.log('Pokémons cargados:', this.linksPokemon);
    });
  }
}