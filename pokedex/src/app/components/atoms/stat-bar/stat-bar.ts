import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-stat-bar',
  imports: [],
  templateUrl: './stat-bar.html',
  styleUrl: './stat-bar.css'
})
export class StatBar {
  @Input() label: string = '';
  @Input() value: number = 0;
  @Input() max: number = 150;

  get percent(): number {
    return Math.min((this.value / this.max) * 100, 100);
  }
}