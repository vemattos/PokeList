package com.vinicius.poke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.poke.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
}
 