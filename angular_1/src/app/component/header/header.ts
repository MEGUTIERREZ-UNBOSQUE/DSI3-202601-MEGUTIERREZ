import { Component, EventEmitter, Input, Output, output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-header',
  imports: [
    FormsModule
  ],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class Header {
  ciclo: number = 1;

  @Input() title!: string;
  @Input() description!: string;
  @Input() actionname!: string;
  @Input() label!: string;
  
  @Output() elements = new EventEmitter<number>();

  calculate(): void {
    console.log("la opcion ingresada es", this.ciclo);
    // Emitimos el valor actual de ciclo
    this.elements.emit(this.ciclo);
  }
}