import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './menu-dashboard.html',
  styleUrl: './menu-dashboard.css'
})
export class MenuDashboardComponent {
  constructor(private router: Router) {}

  navigateTo(path: string): void {
    this.router.navigate([path]);
  }
}