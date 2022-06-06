package com.usuario.servicio.controladores;

import com.usuario.servicio.dto.DTOAutomovil;
import com.usuario.servicio.dto.DTOMotocicleta;
import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.servicios.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioContolador {

    @Autowired
    private UsuarioImpl usuarioImpl;
    @Autowired
    private Usuario usuario;

    @GetMapping(value = "/listaUsuarios")
    public ResponseEntity<List<Usuario>> getAll(){ // ResponseEntity maneja toda la respuesta HTTP incluyendo el cuerpo, cabecera y códigos de estado
        List<Usuario> listaUsuarios = usuarioImpl.getAll();

        if (listaUsuarios.isEmpty()) {
            return ResponseEntity.noContent().build(); // La respuesta seria que no hay nada
        }

        return ResponseEntity.ok(listaUsuarios); // devuelve la lista de usuarios encontrados

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        usuario = usuarioImpl.getById(id);

        if(usuario == null){

            return ResponseEntity.notFound().build(); // no encontrado

        }

        return ResponseEntity.ok(usuario);

    }

    @PostMapping("/nuevoUsuario")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuarioNuevo){
        usuario =  usuarioImpl.save(usuarioNuevo);

        return ResponseEntity.ok(usuario);

    }

    @GetMapping("/automoviles/{idUsuario}")
    public ResponseEntity<List<DTOAutomovil>> getAutos(@PathVariable int idUsuario){
        usuario =  usuarioImpl.getById(idUsuario);

        if(usuario == null){

            return ResponseEntity.notFound().build(); // no encontrado

        }

        List<DTOAutomovil> automoviles =  usuarioImpl.getAutomovil(idUsuario);

        return ResponseEntity.ok(automoviles);

    }

    @GetMapping("/motocicletas/{idUsuario}")
    public ResponseEntity<List<DTOMotocicleta>> getMotos(@PathVariable int idUsuario){
        usuario =  usuarioImpl.getById(idUsuario);

        if(usuario == null){

            return ResponseEntity.notFound().build(); // no encontrado

        }

        List<DTOMotocicleta> DTOMotocicletas =  usuarioImpl.getMotocicletas(idUsuario);

        return ResponseEntity.ok(DTOMotocicletas);

    }

    @PostMapping("/automoviles/{idUsuario}")
    public ResponseEntity<DTOAutomovil> saveAuto(@PathVariable int idUsuario, @RequestBody DTOAutomovil DTOAutomovil){
        DTOAutomovil nuevoDTOAutomovil = usuarioImpl.saveAutomovil(idUsuario, DTOAutomovil);
        return ResponseEntity.ok(nuevoDTOAutomovil);
    }

    @PostMapping("/motocicletas/{idUsuario}")
    public ResponseEntity<DTOMotocicleta> saveMoto(@PathVariable int idUsuario, @RequestBody DTOMotocicleta dtoMotocicleta){
        DTOMotocicleta nuevaMotocicleta = usuarioImpl.saveMotocicleta(idUsuario, dtoMotocicleta);
        return ResponseEntity.ok(nuevaMotocicleta);
    }

    @GetMapping("vehiculos/{idUsuario}")
    public ResponseEntity<Map<String,Object>> allVehiculos(@PathVariable int idUsuario) {
        Map<String, Object> resultado = usuarioImpl.getUserAndVehiculos(idUsuario);
        return ResponseEntity.ok(resultado);
    }


}
