import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogoComponent } from '../../atoms/app-logo/app-logo'; // Ajusta la ruta según tu proyecto

@Component({
  selector: 'app-register-header',
  standalone: true,
  imports: [CommonModule, LogoComponent],
  templateUrl: './register-header.html',
  styleUrl: './register-header.css'
})
export class RegisterHeaderComponent {
  @Input() title: string = 'Crear cuenta';
  @Input() subtitle: string = 'Completa el formulario';
}