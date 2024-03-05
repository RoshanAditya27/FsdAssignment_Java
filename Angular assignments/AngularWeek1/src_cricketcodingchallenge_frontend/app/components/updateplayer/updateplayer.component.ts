import { Component } from '@angular/core';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-updateplayer',
  templateUrl: './updateplayer.component.html',
  styleUrls: ['./updateplayer.component.css'],
})
export class UpdateplayerComponent {
  playerToUpdate: Player = new Player(0, '', '', '', 0, '', '', ''); // Initialize with default values

  constructor(private playerService: PlayerService) {}

  updatePlayer() {
    this.playerService
      .update(this.playerToUpdate.playerId, this.playerToUpdate)
      .subscribe(
        (player) => {
          console.log('Updated Player:', player);
          // Reset the form or handle success as needed
        },
        (error) => {
          console.error('Error updating player:', error);
          // Handle error
        }
      );
  }
}
