import { Component, Input } from '@angular/core';
import { DecimalPipe, UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-pokemon-name',
  imports: [DecimalPipe, UpperCasePipe],
  templateUrl: './pokemon-name.html',
  styleUrl: './pokemon-name.css'
})
export class PokemonName {
  @Input() name: string = '';
  @Input() id: number = 0;
}