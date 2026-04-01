package com.ultima.practica.Clinica.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMascota;
    private String nombre, especie, raza, color;
    @OneToOne
    @JoinColumn(name = "dueno_id_dueno", referencedColumnName = "idDueno")
    private Dueno dueno;
}
