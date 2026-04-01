package com.ultima.practica.Clinica.Service;

import com.ultima.practica.Clinica.Model.Mascota;

import java.util.List;

public interface IMascotaService {

    public void saveMascota(Mascota masco);

    public List<Mascota> getMascotas();

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Mascota masco);
}
