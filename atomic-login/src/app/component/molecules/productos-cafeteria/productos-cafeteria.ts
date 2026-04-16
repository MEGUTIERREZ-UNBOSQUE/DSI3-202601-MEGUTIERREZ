import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-productos-cafeteria',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './productos-cafeteria.html',
  styleUrl: './productos-cafeteria.css'
})
export class ProductosCafeteriaComponent {
  currentSlide = 0;
  products = [
    { name: 'Espresso Clásico', desc: 'Intensidad pura en cada sorbo. Grano de origen único, tostado oscuro.', price: '$4.500', image: 'https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?w=400&q=80', featured: false },
    { name: 'Capuchino Artesanal', desc: 'Espuma sedosa y arte latte creado a mano con leche entera.', price: '$6.500', image: 'https://images.unsplash.com/photo-1572442388796-11668a67e53d?w=400&q=80', featured: true },
    { name: 'Latte Vainilla', desc: 'Suave y aromático. Vainilla natural con nuestro blend exclusivo.', price: '$7.000', image: 'https://images.unsplash.com/photo-1517701550927-30cf4ba1dba5?w=400&q=80', featured: false },
    { name: 'Cold Brew', desc: 'Extracción en frío durante 18 horas. Suave, concentrado y sin acidez.', price: '$7.500', image: 'https://images.unsplash.com/photo-1461023058943-07fcbe16d735?w=400&q=80', featured: false },
    { name: 'Macchiato Caramelo', desc: 'Espresso con leche cremosa y toque de caramelo artesanal.', price: '$8.000', image: 'https://images.unsplash.com/photo-1570517130750-10c67ffdde09?w=400&q=80', featured: false },
    { name: 'Filtrado de Origen', desc: 'Single origin Colombia. Notas frutales y achocolatadas.', price: '$5.500', image: 'https://images.unsplash.com/photo-1447933601403-0c6688de566e?w=400&q=80', featured: false }
  ];

  nextSlide(): void {
    if (this.currentSlide < this.products.length - 3) {
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
    return Array.from({ length: this.products.length - 2 }, (_, i) => i);
  }
}