package com.vinicius.poke.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String type;

}
