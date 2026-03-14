import { Component, Input } from '@angular/core';
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

  calculate(): void {
    console.log("la opcion ingresada es", this.ciclo);
  }
}
