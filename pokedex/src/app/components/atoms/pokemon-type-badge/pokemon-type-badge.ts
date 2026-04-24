import { Component, Input } from '@angular/core';
import { UpperCasePipe } from '@angular/common';

@Component({
  selector: 'app-pokemon-type-badge',
  imports: [UpperCasePipe],
  templateUrl: './pokemon-type-badge.html',
  styleUrl: './pokemon-type-badge.css'
})
export class PokemonTypeBadge {
  @Input() type: string = '';

  get color(): string {
    return `var(--type-${this.type})`;
  }
}