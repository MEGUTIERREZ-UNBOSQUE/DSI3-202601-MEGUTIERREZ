import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PokemonDto } from '../models/pokemon.dto';
import { PokemonListResponseDto } from '../models/pokemon-list.dto';

@Injectable({ providedIn: 'root' })
export class PokemonService {

  private http = inject(HttpClient);
  private baseUrl = 'https://pokeapi.co/api/v2';

  getPokemons(limit = 20, offset = 0): Observable<PokemonListResponseDto> {
    return this.http.get<PokemonListResponseDto>(
      `${this.baseUrl}/pokemon?limit=${limit}&offset=${offset}`
    );
  }

  getPokemonByName(name: string): Observable<PokemonDto> {
    return this.http.get<PokemonDto>(`${this.baseUrl}/pokemon/${name}`);
  }
}