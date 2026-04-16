import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-game-row',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './game-row.html',
  styleUrl: './game-row.css'
})
export class GameRowComponent {
  @Input() index: number = 0;
  @Input() selected: string = '';
  @Input() options: string[] = [];
  @Output() selectedChange = new EventEmitter<string>();

  onSelect(event: Event): void {
    const select = event.target as HTMLSelectElement;
    this.selectedChange.emit(select.value);
  }
}