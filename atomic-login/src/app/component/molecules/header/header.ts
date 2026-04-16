import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class HeaderComponent {
  ciclo: number = 1;

  @Input() title: string = '';
  @Input() description: string = '';
  @Input() actionname: string = '';
  @Input() label: string = '';
  
  @Output() elements = new EventEmitter<number>();

  calculate(): void {
    this.elements.emit(this.ciclo);
  }
}