import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ButtomComponent } from '../../atoms/buttom/buttom';
import { LinkTextComponent } from '../../atoms/link-text/link-text';

@Component({
  selector: 'app-login-actions',
  standalone: true,
  imports: [ButtomComponent, LinkTextComponent],
  templateUrl: './login-actions.html',
  styleUrl: './login-actions.css'
})
export class LoginActionsComponent {
  @Input() loading: boolean = false;
  @Output() onSubmit = new EventEmitter<void>();

  handleClick(): void {
    this.onSubmit.emit();
  }
}