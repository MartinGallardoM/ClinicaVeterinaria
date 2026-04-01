package com.ultima.practica.Clinica.Service;

import com.ultima.practica.Clinica.Model.Dueno;

import java.util.List;

public interface IDuenoService {

    public void saveDueno(Dueno dueno);

    public List<Dueno> getDueno();

    public void deleteDueno(Long id);

    public Dueno findDueno(Long id);

    public void editDueno(Dueno dueno);
}
