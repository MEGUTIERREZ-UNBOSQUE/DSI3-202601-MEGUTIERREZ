import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldAtomComponent } from '../../atoms/input-field/input-field';
import { ErrorMessageComponent } from '../../atoms/error-message/error-message';

@Component({
  selector: 'app-input-field-molecule',
  standalone: true,
  imports: [CommonModule, InputFieldAtomComponent, ErrorMessageComponent],
  templateUrl: './input-field.html',
  styleUrl: './input-field.css'
})
export class InputFieldMoleculeComponent {
  @Input() label: string = '';
  @Input() fieldId: string = '';
  @Input() type: string = 'text';
  @Input() placeholder: string = '';
  @Input() value: string = '';
  @Input() errorMsg: string = '';
  @Output() valueChange = new EventEmitter<string>();
}