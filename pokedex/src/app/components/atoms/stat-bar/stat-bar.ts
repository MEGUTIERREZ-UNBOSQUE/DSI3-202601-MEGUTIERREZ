  import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-stat-bar',
  standalone: true,
  imports: [],
  templateUrl: './stat-bar.html',
  styleUrl: './stat-bar.css'
})
export class StatBar {
  @Input() label: string = '';
  @Input() value: number = 0;
  @Input() max: number = 150;
}