import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-newsletter-cafeteria',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './newsletter-cafeteria.html',
  styleUrl: './newsletter-cafeteria.css'
})
export class NewsletterCafeteriaComponent {
  name: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  successMessage: string = '';

  onSubmit(): void {
    if (this.name && this.email && this.password && this.confirmPassword) {
      if (this.password === this.confirmPassword) {
        this.successMessage = '¡Registro exitoso!';
        setTimeout(() => this.successMessage = '', 3000);
      }
    }
  }
}