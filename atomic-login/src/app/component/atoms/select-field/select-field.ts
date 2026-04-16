import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-select-field', 
  standalone: true,
  imports: [CommonModule],
  templateUrl: './select-field.html',
  styleUrl: './select-field.css'
})
export class SelectFieldComponent {
  @Input() label: string = '';
  @Input() fieldId: string = '';
  @Input() placeholder: string = 'Selecciona una opción';
  @Input() value: string = '';
  @Input() options: { label: string, value: any }[] = [
    { label: 'Ingeniería de Sistemas', value: 'sistemas' },
    { label: 'Ingeniería Industrial', value: 'industrial' },
    { label: 'Psicología', value: 'psicologia' }
  ];
  @Output() valueChange = new EventEmitter<string>();

  onChange(event: Event) {
    const select = event.target as HTMLSelectElement;
    this.valueChange.emit(select.value);
  }
}