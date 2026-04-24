import { Component, inject } from '@angular/core';
import { NgIf } from '@angular/common';
import { PokemonService } from '../../core/services/pokemon';
import { PokemonDto } from '../../core/models/pokemon.dto';
import { PokemonGrid } from '../../components/organisms/pokemon-grid/pokemon-grid';
import { PokemonDetail } from '../../components/organisms/pokemon-detail/pokemon-detail';

@Component({
  selector: 'app-pokemon-pages',
  imports: [ PokemonGrid, PokemonDetail],
  templateUrl: './pokemon-pages.html',
  styleUrl: './pokemon-pages.css'
})
export class PokemonPage {
  pokemons: PokemonDto[] = [];
  selectedPokemon: PokemonDto | null = null;
  offset = 0;
  readonly limit = 20;

  private pokemonService = inject(PokemonService);

  constructor() {
    this.load();
  }

  load() {
    this.pokemonService.getPokemons(this.offset, this.limit).subscribe(result => {
      this.pokemons = result;
    });
  }

  onNext() {
    this.offset += this.limit;
    this.load();
  }

  onPrev() {
    if (this.offset > 0) {
      this.offset -= this.limit;
      this.load();
    }
  }

  onSelect(pokemon: PokemonDto) {
    this.selectedPokemon = pokemon;
  }

  onSearch(query: string) {
    this.pokemonService.getPokemon(query).subscribe(result => {
      this.selectedPokemon = result;
    });
  }
}