export class Player {
  playerId: number = 0;
  playerName: string = '';
  jerseyNumber: string = '';
  role: string = '';
  totalMatches: number = 0;
  teamName: string = '';
  countryOrStateName: string = '';
  description: string = '';

  constructor(
    playerId: number,
    playerName: string,
    jerseyNumber: string,
    role: string,
    totalMatches: number,
    teamName: string,
    countryOrStateName: string,
    description: string
  ) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.jerseyNumber = jerseyNumber;
    this.role = role;
    this.totalMatches = totalMatches;
    this.teamName = teamName;
    this.countryOrStateName = countryOrStateName;
    this.description = description;
  }
}
