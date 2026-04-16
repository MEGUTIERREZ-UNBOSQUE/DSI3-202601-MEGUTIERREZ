import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHeaderComponent } from '../../molecules/register-header/register-header';
import { InputFieldMoleculeComponent } from '../../molecules/input-field/input-field';
import { SelectFieldComponent } from '../../atoms/select-field/select-field';
import { ButtomComponent } from '../../atoms/buttom/buttom';
import { LinkTextComponent } from '../../atoms/link-text/link-text';

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [
    CommonModule, 
    RegisterHeaderComponent, 
    InputFieldMoleculeComponent,
    SelectFieldComponent,
    ButtomComponent,
    LinkTextComponent
  ],
  templateUrl: './register-form.html',
  styleUrl: './register-form.css'
})
export class RegisterFormComponent {
  selectedCareer: string = '';
}