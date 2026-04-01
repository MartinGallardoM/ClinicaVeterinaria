package com.ultima.practica.Clinica.Service;

import com.ultima.practica.Clinica.Model.Dueno;
import com.ultima.practica.Clinica.Repository.IDuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService implements IDuenoService{

    @Autowired
    private IDuenoRepository duenoRepo;

    @Override
    public void saveDueno(Dueno dueno) {
        duenoRepo.save(dueno);
    }

    @Override
    public List<Dueno> getDueno() {
        List<Dueno> listaDuenios = duenoRepo.findAll();
        return listaDuenios;
    }

    @Override
    public void deleteDueno(Long id) {
        duenoRepo.deleteById(id);
    }

    @Override
    public Dueno findDueno(Long id) {
        Dueno duenio = duenoRepo.findById(id).orElse(null);
        return duenio;
    }

    @Override
    public void editDueno(Dueno dueno) {
        this.saveDueno(dueno);
    }
}
