package com.ultima.practica.Clinica.Controller;

import com.ultima.practica.Clinica.Model.Dueno;
import com.ultima.practica.Clinica.Service.IDuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenoController {

    @Autowired
    private IDuenoService duenoServ;

    @PostMapping("/dueno/crear")
    public String crearDuenio(@RequestBody Dueno dueno){
        duenoServ.saveDueno(dueno);
        return "El dueño se creo correctamente";
    }

    @GetMapping("/dueno/traerTodo")
    public List<Dueno> listaDueno(){
        return duenoServ.getDueno();
    }

    @DeleteMapping("/dueno/eliminar/{id}")
    public String eliminarDueno(@PathVariable Long id){
        duenoServ.deleteDueno(id);
        return "El dueño se elimino correctamente";
    }

    @GetMapping("/dueno/traerUno/{id}")
    public Dueno traerUnDueno(@PathVariable Long id){
        return duenoServ.findDueno(id);
    }

    @PutMapping("/dueno/editar")
    public Dueno editarDueno(@RequestBody Dueno dueno){
        duenoServ.editDueno(dueno);
        return duenoServ.findDueno(dueno.getIdDueno());
    }

}
