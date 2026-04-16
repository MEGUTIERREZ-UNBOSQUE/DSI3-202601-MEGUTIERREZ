import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-buttom',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './buttom.html',
  styleUrl: './buttom.css'
})
export class ButtomComponent {
  @Input() label: string = 'Ingresar';
  @Input() variant: string = 'primary';
  @Input() disabled: boolean = false;
  @Output() clicked = new EventEmitter<void>();

  onClick(): void {
    if (!this.disabled) {
      this.clicked.emit();
    }
  }
}