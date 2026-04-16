import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarCafeteriaComponent } from '../../molecules/navbar-cafeteria/navbar-cafeteria';
import { HeroCafeteriaComponent } from '../../molecules/hero-cafeteria/hero-cafeteria';
import { HistoriaCafeteriaComponent } from '../../molecules/historia-cafeteria/historia-cafeteria';
import { ProductosCafeteriaComponent } from '../../molecules/productos-cafeteria/productos-cafeteria';
import { TestimoniosCafeteriaComponent } from '../../molecules/testimonios-cafeteria/testimonios-cafeteria';
import { NewsletterCafeteriaComponent } from '../../molecules/newsletter-cafeteria/newsletter-cafeteria';
import { FooterCafeteriaComponent } from '../../molecules/footer-cafeteria/footer-cafeteria';

@Component({
  selector: 'app-cafeteria-arena',
  standalone: true,
  imports: [
    CommonModule,
    NavbarCafeteriaComponent,
    HeroCafeteriaComponent,
    HistoriaCafeteriaComponent,
    ProductosCafeteriaComponent,
    TestimoniosCafeteriaComponent,
    NewsletterCafeteriaComponent,
    FooterCafeteriaComponent
  ],
  templateUrl: './cafeteria-arena.html',
  styleUrl: './cafeteria-arena.css'
})
export class CafeteriaArenaComponent {}