import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Player } from '../model/player'; // Assuming the Player model is named 'Player'

@Injectable({
  providedIn: 'root',
})
export class PlayerService {
  constructor(private http: HttpClient) {}

  baseURL: string = 'http://localhost:8080/api/players/';

  getAll(): Observable<Player[]> {
    return this.http.get<Player[]>(this.baseURL + 'getall');
  }

  insert(body: Player): Observable<Player> {
    return this.http.post<Player>(this.baseURL + 'add', body);
  }

  delete(playerId: number): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}deleteByid/${playerId}`);
  }

  getById(playerId: number): Observable<Player> {
    return this.http.get<Player>(`${this.baseURL}get/${playerId}`);
  }

  getByPlayerName(playerName: string): Observable<Player> {
    return this.http.get<Player>(`${this.baseURL}get-by-name/${playerName}`);
  }

  update(playerId: number, player: Player): Observable<Player> {
    return this.http.put<Player>(`${this.baseURL}update/${playerId}`, player);
  }
}
