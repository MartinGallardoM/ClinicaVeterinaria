package com.ultima.practica.Clinica.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dueno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDueno;
    private String dni;
    private String nombre, apellido;
    private String celular;
}