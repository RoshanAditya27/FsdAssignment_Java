import { Component } from '@angular/core';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-displayall',
  templateUrl: './displayall.component.html',
  styleUrls: ['./displayall.component.css'],
})
export class DisplayallComponent {
  playerList: Player[] = [];

  constructor(private playerService: PlayerService) {}

  ngOnInit() {
    this.getAllPlayers();
  }

  getAllPlayers() {
    this.playerService.getAll().subscribe((list) => {
      this.playerList = list;
      console.log(list);
    });
  }

  deleteById(playerId: number) {
    this.playerService.delete(playerId).subscribe((msg) => {
      console.log('Deleted ' + msg);
      this.getAllPlayers(); // Refresh the list
    });
  }
}
