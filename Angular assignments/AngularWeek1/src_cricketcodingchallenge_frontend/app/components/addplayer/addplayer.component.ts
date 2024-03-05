import { Component } from '@angular/core';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-addplayer',
  templateUrl: './addplayer.component.html',
  styleUrls: ['./addplayer.component.css'],
})
export class AddplayerComponent {
  constructor(private playerService: PlayerService) {}

  insertPlayer(data: Player) {
    this.playerService.insert(data).subscribe(
      (player) => {
        console.log('Added Player:', player);
        // Reset the form or handle success as needed
      },
      (error) => {
        console.error('Error adding player:', error);
        // Handle error
      }
    );
  }
}
