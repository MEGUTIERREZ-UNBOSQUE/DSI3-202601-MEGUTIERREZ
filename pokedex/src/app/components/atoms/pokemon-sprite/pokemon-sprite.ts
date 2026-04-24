import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pokemon-sprite',
  imports: [],
  templateUrl: './pokemon-sprite.html',
  styleUrl: './pokemon-sprite.css'
})
export class PokemonSprite {
  @Input() src: string = '';
  @Input() alt: string = '';
  @Input() size: string = '6rem';
}