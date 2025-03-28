package com.vinicius.poke.service;

import com.vinicius.poke.model.Pokemon;
import com.vinicius.poke.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> updatePokemon(Long id, Pokemon pokemon) {
        if (pokemonRepository.existsById(id)) {
            pokemon.setId(id);
            return Optional.of(pokemonRepository.save(pokemon));
        }
        return Optional.empty();
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }
}