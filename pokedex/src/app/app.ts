import { Component, signal, inject, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PokemonService } from './core/services/pokemon';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('pokedex');

  private pokemonService = inject(PokemonService);

  ngOnInit() {
    this.pokemonService.getPokemons().subscribe(data => {
      console.log('PokeAPI responde:', data);
    });
  }
}