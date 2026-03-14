import { Component } from '@angular/core';
import { Header } from "../../component/header/header";

@Component({
  selector: 'app-game',
  imports: [ Header],
  templateUrl: './game.html',
  styleUrl: './game.css',
})
export class Game {}
