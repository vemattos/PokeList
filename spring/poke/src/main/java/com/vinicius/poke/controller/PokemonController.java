package com.vinicius.poke.controller;

import java.util.List;

import com.vinicius.poke.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.poke.model.Pokemon;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin("http://localhost:4200")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<List<Pokemon>> getAllPokemons() {
        List<Pokemon> pokemons = pokemonService.getAllPokemons();
        return pokemons.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(pokemons);
    }


    @GetMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable @NonNull Long id) {
        return pokemonService.getPokemonById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        Pokemon savedPokemon = pokemonService.createPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPokemon);
    }

    @PutMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable @NonNull Long id, @RequestBody Pokemon pokemon){
        return pokemonService.updatePokemon(id, pokemon)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable @NonNull Long id){
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }
}
