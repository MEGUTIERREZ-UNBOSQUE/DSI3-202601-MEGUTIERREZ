import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-link-text',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './link-text.html',
  styleUrl: './link-text.css'
})
export class LinkTextComponent {
  @Input() text: string = '';
  @Input() href: string = '#';
}