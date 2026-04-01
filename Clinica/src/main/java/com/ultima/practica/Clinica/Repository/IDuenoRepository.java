package com.ultima.practica.Clinica.Repository;

import com.ultima.practica.Clinica.Model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDuenoRepository extends JpaRepository<Dueno, Long> {
}
