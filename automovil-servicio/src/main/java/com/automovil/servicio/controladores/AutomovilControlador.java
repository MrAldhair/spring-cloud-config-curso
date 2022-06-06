package com.automovil.servicio.controladores;

import com.automovil.servicio.entidades.Automovil;
import com.automovil.servicio.servicios.AutomovilImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automoviles")
public class AutomovilControlador {

    @Autowired
    private AutomovilImp automovilImp;

    @GetMapping(value = "/listaAutomoviles")
    public ResponseEntity<List<Automovil>> getAll(){
        List<Automovil> listaAutomoviles = automovilImp.getAll();

        if (listaAutomoviles.isEmpty()) {

            return ResponseEntity.noContent().build(); // La respuesta seria que no hay nada

        }

        return ResponseEntity.ok(listaAutomoviles); // devuelve la lista de usuarios encontrados
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Automovil> findById(@PathVariable Integer id){
        Automovil busquedaAutomovil = automovilImp.getById(id);

        if(busquedaAutomovil == null){

            return ResponseEntity.notFound().build(); // no encontrado

        }

        return ResponseEntity.ok(busquedaAutomovil);

    }

    @PostMapping("/nuevoAutomovil")
    public ResponseEntity<Automovil> save(@RequestBody Automovil automovilNuevo){
        Automovil NuevoAutomovil =  automovilImp.save(automovilNuevo);

        return ResponseEntity.ok(NuevoAutomovil);

    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Automovil>> findAutoByIdUser(@PathVariable int idUsuario){
        List<Automovil> automoviles =  automovilImp.findAutoByIdUser(idUsuario);
        if(automoviles.isEmpty()) {

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.ok(automoviles);

    }

}
