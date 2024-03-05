import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent {
  searchData: string = ''; // Define searchData property

  constructor(private playerService: PlayerService, private router: Router) {}

  find(searchForm: any) {
    this.router.navigate(['/search/' + this.searchData]);

    console.log(this.searchData);
  }
}
