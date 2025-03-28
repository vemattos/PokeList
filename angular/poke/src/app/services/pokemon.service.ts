import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, first } from 'rxjs';
import { Pokemon } from '../Pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private readonly API = 'http://localhost:8080/api/pokemon';

  constructor(private readonly http: HttpClient) { }

  getAllPokemon(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.API);
  }

  createPokemon(pokemon: Partial<Pokemon>) {
    return this.http.post<Pokemon>(this.API, pokemon).pipe(first());
  }

  updatePokemon(id: number, pokemon: Partial<Pokemon>) {
    return this.http.put<Pokemon>(`${this.API}/${id}`, pokemon);
  }

  deletePokemon(id: number) {
    return this.http.delete(`${this.API}/${id}`);
  }
}
