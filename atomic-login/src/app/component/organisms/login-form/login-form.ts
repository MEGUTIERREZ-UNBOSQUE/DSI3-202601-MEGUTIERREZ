import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginHeaderComponent } from '../../molecules/login-header/login-header';
import { InputFieldMoleculeComponent } from '../../molecules/input-field/input-field';
import { LoginActionsComponent } from '../../molecules/login-actions/login-actions';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    LoginHeaderComponent,
    InputFieldMoleculeComponent,
    LoginActionsComponent
  ],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css'
})
export class LoginFormComponent {
  email: string = '';
  password: string = '';
  emailError: string = '';
  passwordError: string = '';
  loading: boolean = false;

  constructor(private router: Router) {}

  handleLogin() {
    this.emailError = '';
    this.passwordError = '';

    if (!this.email) {
      this.emailError = 'El correo es obligatorio';
      return;
    }
    if (!this.email.includes('@')) {
      this.emailError = 'Ingresa un correo válido';
      return;
    }
    if (!this.password) {
      this.passwordError = 'La contraseña es obligatoria';
      return;
    }
    if (this.password.length < 6) {
      this.passwordError = 'Mínimo 6 caracteres';
      return;
    }

    this.loading = true;
    setTimeout(() => {
      this.loading = false;
      this.router.navigate(['/menu']);
    }, 800);
  }

  navigateToRegister(): void {
    this.router.navigate(['/register']);
  }
}