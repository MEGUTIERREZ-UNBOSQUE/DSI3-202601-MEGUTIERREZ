import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-mundial',
  imports: [FormsModule],
  templateUrl: './mundial.html',
  styleUrl: './mundial.css',
})
export class Mundial {
  cantidad: number = 1;
  partidos: { colombiaGoles: number; franciaGoles: number }[] = [];
  ganador: string = '';

  generarPartidos(): void {
    if (this.cantidad < 1 || this.cantidad > 100) return;
    this.ganador = '';
    this.partidos = Array.from({ length: this.cantidad }, () => ({
      colombiaGoles: 0,
      franciaGoles: 0,
    }));
  }

  calcularGanador(): void {
    let colombiaPartidos = 0;
    let franciaPartidos = 0;
    let colombiaGolesTotales = 0;
    let franciaGolesTotales = 0;

    for (var i = 0; i < this.partidos.length; i++) {
      var p = this.partidos[i];
      colombiaGolesTotales += p.colombiaGoles;
      franciaGolesTotales += p.franciaGoles;

      if (p.colombiaGoles > p.franciaGoles) {
        colombiaPartidos++;
      } else if (p.franciaGoles > p.colombiaGoles) {
        franciaPartidos++;
      }
    }

    if (colombiaPartidos > franciaPartidos) {
      this.ganador = `🇨🇴 Colombia (${colombiaPartidos} partidos, ${colombiaGolesTotales} goles)`;
    } else if (franciaPartidos > colombiaPartidos) {
      this.ganador = `🇫🇷 Francia (${franciaPartidos} partidos, ${franciaGolesTotales} goles)`;
    } else {
      if (colombiaGolesTotales > franciaGolesTotales) {
        this.ganador = `🇨🇴 Colombia por goles (${colombiaGolesTotales} vs ${franciaGolesTotales})`;
      } else if (franciaGolesTotales > colombiaGolesTotales) {
        this.ganador = `🇫🇷 Francia por goles (${franciaGolesTotales} vs ${colombiaGolesTotales})`;
      } else {
        this.ganador = `Empate total (${colombiaPartidos} partidos, ${colombiaGolesTotales} goles c/u)`;
      }
    }
  }
}