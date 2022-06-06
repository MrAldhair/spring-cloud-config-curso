package com.motocicleta.servicio.controladores;

import com.motocicleta.servicio.entidades.Motocicleta;
import com.motocicleta.servicio.servicios.MotocicletaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/motocicletas")
public class MotocicletaControlador {

    @Autowired
    private MotocicletaImpl motocicleta;
    @Autowired
    private Motocicleta nuevaMotocicleta;

    @GetMapping(value = "/listaMotocicletas")
    public ResponseEntity<List<Motocicleta>> getAll(){
        List<Motocicleta> listaMotocicletas = motocicleta.getAll();

        if (listaMotocicletas.isEmpty()) {
            return ResponseEntity.
                    noContent().
                    build(); // La respuesta seria que no hay nada
        }

        return ResponseEntity.ok(listaMotocicletas); // devuelve la lista de usuarios encontrados
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Motocicleta> findById(@PathVariable Integer id){
        nuevaMotocicleta = motocicleta.getById(id);

        if(nuevaMotocicleta == null){
            return ResponseEntity
                    .notFound()
                    .build(); // no encontrado
        }

        return ResponseEntity.ok(nuevaMotocicleta);
    }

    @PostMapping("/nuevaMotocicleta")
    public ResponseEntity<Motocicleta> save(@RequestBody Motocicleta motocicletaNueva){
        nuevaMotocicleta =  motocicleta.save(motocicletaNueva);
        return ResponseEntity.ok(nuevaMotocicleta);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Motocicleta>> findAutoByIdUser(@PathVariable int idUsuario){
        List<Motocicleta> motocicletas =  motocicleta.findMotoByUser(idUsuario);
        if(motocicletas.isEmpty()) {
            return ResponseEntity.
                    noContent()
                    .build();
        }

        return ResponseEntity.ok(motocicletas);
    }

}
