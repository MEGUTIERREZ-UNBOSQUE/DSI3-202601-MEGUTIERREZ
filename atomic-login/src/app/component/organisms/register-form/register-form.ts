import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RegisterHeaderComponent } from '../../molecules/register-header/register-header';
import { InputFieldMoleculeComponent } from '../../molecules/input-field/input-field';
import { SelectFieldComponent } from '../../atoms/select-field/select-field';
import { ButtomComponent } from '../../atoms/buttom/buttom';

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [
    CommonModule, 
    RegisterHeaderComponent, 
    InputFieldMoleculeComponent,
    SelectFieldComponent,
    ButtomComponent
  ],
  templateUrl: './register-form.html',
  styleUrl: './register-form.css'
})
export class RegisterFormComponent {
  selectedCareer: string = '';

  constructor(private router: Router) {}

  navigateToLogin(): void {
    this.router.navigate(['/']);
  }
}