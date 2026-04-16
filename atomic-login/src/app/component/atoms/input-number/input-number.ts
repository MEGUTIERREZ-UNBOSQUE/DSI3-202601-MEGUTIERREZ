import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-input-number',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './input-number.html',
  styleUrl: './input-number.css'
})
export class InputNumberComponent {
  @Input() value: number = 0;
  @Input() min: number = 0;
  @Input() max: number = 100;
  @Input() placeholder: string = '';
  @Output() valueChange = new EventEmitter<number>();

  onInput(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.valueChange.emit(Number(input.value));
  }
}