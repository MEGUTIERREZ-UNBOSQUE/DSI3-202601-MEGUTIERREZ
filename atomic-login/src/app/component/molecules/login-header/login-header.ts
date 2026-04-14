import { Component } from '@angular/core';
import { LogoComponent } from '../../atoms/app-logo/app-logo';

@Component({
  selector: 'app-login-header',
  standalone: true,
  imports: [LogoComponent],
  templateUrl: './login-header.html',
  styleUrl: './login-header.css'
})
export class LoginHeaderComponent {}