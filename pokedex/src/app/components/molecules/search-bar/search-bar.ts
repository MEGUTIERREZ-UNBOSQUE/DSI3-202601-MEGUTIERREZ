import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-bar',
  imports: [FormsModule],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.css'
})
export class SearchBar {
  query: string = '';
  @Output() searched = new EventEmitter<string>();

  onSearch() {
    this.searched.emit(this.query.trim().toLowerCase());
  }
}