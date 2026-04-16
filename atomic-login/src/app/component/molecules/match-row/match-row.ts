import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputNumberComponent } from '../../atoms/input-number/input-number';

@Component({
  selector: 'app-match-row',
  standalone: true,
  imports: [CommonModule, InputNumberComponent],
  templateUrl: './match-row.html',
  styleUrl: './match-row.css'
})
export class MatchRowComponent {
  @Input() index: number = 0;
  @Input() team1Goals: number = 0;
  @Input() team2Goals: number = 0;
  @Input() team1Name: string = '';
  @Input() team2Name: string = '';
  @Input() team1Flag: string = '';
  @Input() team2Flag: string = '';
  @Output() team1GoalsChange = new EventEmitter<number>();
  @Output() team2GoalsChange = new EventEmitter<number>();
}