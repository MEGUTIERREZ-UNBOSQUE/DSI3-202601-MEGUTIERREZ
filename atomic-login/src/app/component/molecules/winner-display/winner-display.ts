import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-winner-display',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './winner-display.html',
  styleUrl: './winner-display.css'
})
export class WinnerDisplayComponent {
  @Input() winner: string = '';
  @Input() label: string = 'GANADOR';
}