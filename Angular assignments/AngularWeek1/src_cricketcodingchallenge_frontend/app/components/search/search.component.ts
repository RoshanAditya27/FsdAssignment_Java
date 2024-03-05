import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Player } from 'src/app/model/player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  playerSearchList: Player[] = [];
  searchInput: string = '';

  constructor(
    private route: ActivatedRoute,
    private playerService: PlayerService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((param) => {
      this.searchInput = param['input'];
      this.find();
    });
  }

  find() {
    // Check if the search input is a number (for player ID search) or a string (for player name search)
    const searchValue = +this.searchInput;
    if (!isNaN(searchValue)) {
      // If the search input is a number, search by player ID
      this.playerService.getById(searchValue).subscribe(
        (player: Player) => {
          // Wrap the single player result in an array
          this.playerSearchList = player ? [player] : [];
          console.log('Player ID search result:', this.playerSearchList);
        },
        (error) => {
          console.error('Error:', error);
          this.playerSearchList = [];
        }
      );
    } else {
      // If the search input is not a number, search by player name
      this.playerService.getByPlayerName(this.searchInput).subscribe(
        (player: Player) => {
          // Wrap the single player result in an array
          this.playerSearchList = player ? [player] : [];
          console.log('Player name search result:', this.playerSearchList);
        },
        (error) => {
          console.error('Error:', error);
          this.playerSearchList = [];
        }
      );
    }
  }
}
