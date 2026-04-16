import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogoComponent } from '../../atoms/app-logo/app-logo';

@Component({
  selector: 'app-register-header',
  standalone: true,
  imports: [CommonModule, LogoComponent],
  templateUrl: './register-header.html',
  styleUrl: './register-header.css'
})
export class RegisterHeaderComponent {}
