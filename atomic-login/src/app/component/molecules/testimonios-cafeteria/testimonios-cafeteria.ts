import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-testimonios-cafeteria',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './testimonios-cafeteria.html',
  styleUrl: './testimonios-cafeteria.css'
})
export class TestimoniosCafeteriaComponent {
  currentSlide = 0;
  
  testimonials = [
    { text: '"El mejor café de la ciudad, sin duda. El ambiente es mágico y el capuchino es simplemente perfecto."', author: 'María Fernández', avatar: 'brown1' },
    { text: '"Llevo 5 años viniendo cada mañana. Es mi lugar favorito para comenzar el día con energía y tranquilidad."', author: 'Carlos Mejía', avatar: 'brown2' },
    { text: '"La atención es impecable. Se nota que cada detalle está pensado para que te sientas especial."', author: 'Ana Rodríguez', avatar: 'gold' },
    { text: '"Descubrí este lugar hace un año y ya no puedo imaginar mi semana sin su filtrado de origen."', author: 'Juliana Torres', avatar: 'brown1' },
    { text: '"El cold brew es una obra de arte. Vine de visita y fue lo mejor que probé."', author: 'Sebastián Mora', avatar: 'brown2' },
    { text: '"Celebré mi cumpleaños aquí y el equipo nos sorprendió con detalles increíbles."', author: 'Laura Gómez', avatar: 'gold' }
  ];

  nextSlide(): void {
    if (this.currentSlide < this.testimonials.length - 3) {
      this.currentSlide++;
    }
  }

  prevSlide(): void {
    if (this.currentSlide > 0) {
      this.currentSlide--;
    }
  }

  goToSlide(index: number): void {
    this.currentSlide = index;
  }

  getDots(): number[] {
    return Array.from({ length: this.testimonials.length - 2 }, (_, i) => i);
  }

  getStars(): number[] {
    return [1, 2, 3, 4, 5];
  }
}