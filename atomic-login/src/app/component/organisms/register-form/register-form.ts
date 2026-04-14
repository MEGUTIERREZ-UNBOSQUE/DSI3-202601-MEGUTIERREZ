import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHeaderComponent } from '../../molecules/register-header/register-header';
import { PersonalDataFormComponent } from '../../molecules/personal-data-form/personal-data-form';
import { ButtomComponent } from '../../atoms/buttom/buttom'; // <-- Verifica esta ruta y nombre de clase

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [
    CommonModule, 
    RegisterHeaderComponent, 
    PersonalDataFormComponent, 
    ButtomComponent // <-- Agrégalo aquí
  ],
  templateUrl: './register-form.html',
  styleUrl: './register-form.css'
})
export class RegisterFormComponent {}
