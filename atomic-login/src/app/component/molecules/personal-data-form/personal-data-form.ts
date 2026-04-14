import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldAtomComponent } from '../../atoms/input-field/input-field';
import { SelectFieldComponent } from '../../atoms/select-field/select-field';

@Component({
  selector: 'app-personal-data-form',
  standalone: true,
  imports: [CommonModule, InputFieldAtomComponent, SelectFieldComponent],
  templateUrl: './personal-data-form.html',
  styleUrl: './personal-data-form.css'
})
export class PersonalDataFormComponent {
  careerOptions = [
    { label: 'Ingeniería de Sistemas', value: 'sistemas' },
    { label: 'Ingeniería Industrial', value: 'industrial' },
    { label: 'Psicología', value: 'psicologia' }
  ];
}