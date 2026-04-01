package com.ultima.practica.Clinica.Controller;

import com.ultima.practica.Clinica.DTO.duenoMascotaDTO;
import com.ultima.practica.Clinica.DTO.mascotaDTO;
import com.ultima.practica.Clinica.Model.Mascota;
import com.ultima.practica.Clinica.Service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascoServ;

    @PostMapping("/mascota/crear")
    public String crearMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);
        return "La mascota se creo correctamente";
    }

    @GetMapping("/mascota/traerTodo")
    public List<Mascota> traerMascota(){
        return mascoServ.getMascotas();
    }

    @DeleteMapping("/mascota/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id){
        mascoServ.deleteMascota(id);
        return "La mascota se elimino correctamente";
    }

    @GetMapping("/mascota/traerUno/{id}")
    public Mascota traerUnaMascota(@PathVariable Long id){
        return mascoServ.findMascota(id);
    }

    @PutMapping("/mascota/editar")
    public Mascota editarMascota(@RequestBody Mascota masco){
        mascoServ.editMascota(masco);
        return mascoServ.findMascota(masco.getIdMascota());
    }

    /*Obtener el listado de todas las mascotas de especie "perro" y raza "caniche"*/

    @GetMapping("/mascotas/traerAlgunos")
    public List<mascotaDTO> listaMascotasAlgunos(){
        List<mascotaDTO> listaMascotaNueva = new ArrayList<>();
        for (Mascota masco : mascoServ.getMascotas()){
            if (masco.getEspecie().toLowerCase().contains("perro") && masco.getRaza().toLowerCase().contains("caniche")){
                mascotaDTO dto = new mascotaDTO();
                dto.setNombre(masco.getNombre());
                dto.setEspecie(masco.getEspecie());
                dto.setRaza(masco.getRaza());
                dto.setColor(masco.getColor());
                listaMascotaNueva.add(dto);
            }
        }
        return listaMascotaNueva;
    }

    @GetMapping("/mascota/dto/{id}")
    public duenoMascotaDTO duenoMascota(@PathVariable Long id){
        duenoMascotaDTO dto = new duenoMascotaDTO();
        Mascota unaMasco = mascoServ.findMascota(id);
        dto.setNombreMascota(unaMasco.getNombre());
        dto.setEspecie(unaMasco.getEspecie());
        dto.setRaza(unaMasco.getRaza());
        dto.setNombreDuenio(unaMasco.getDueno().getNombre());
        dto.setApellidoDuenio(unaMasco.getDueno().getApellido());
        return dto;
    }
}
