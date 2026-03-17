import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Header } from "../../component/header/header";

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [Header, FormsModule],
  templateUrl: './game.html',
  styleUrl: './game.css',
})
export class Game {
  elements: number = 0;
  jugadores: string[] = ['Alice', 'Bob', 'Empate'];
  selecciones: string[] = [];
  ganador: string = "";
  generateelements(event: number): void {
    this.elements = event;
    this.ganador = ""; 
    this.selecciones = new Array(this.elements).fill('');
    console.log("Generando campos para:", this.elements);
  }

  calcularwinner(): void {
    let alicepoints = 0; 
    let bobpoints = 0;
    let empatepoints = 0;

    for (let juego of this.selecciones) {
      if (juego === 'Alice') {
        alicepoints++;
      } else if (juego === 'Bob') {
        bobpoints++;
      } else if (juego === 'Empate') {
        empatepoints++;
      }
    }

    if (alicepoints > bobpoints) {
      this.ganador = `Alice (Puntos: ${alicepoints})`;
    } else if (bobpoints > alicepoints) {
      this.ganador = `Bob (Puntos: ${bobpoints})`;
    } else {
      this.ganador = `Empate (Partidas empatadas: ${empatepoints})`;
    }
  }
}