package com.usuario.servicio.servicios;

import com.usuario.servicio.ClientesFeign.AutomovilClienteFeign;
import com.usuario.servicio.ClientesFeign.MotocicletaClienteFeign;
import com.usuario.servicio.dto.DTOAutomovil;
import com.usuario.servicio.dto.DTOMotocicleta;
import com.usuario.servicio.entidades.Usuario;
import com.usuario.servicio.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioImpl{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private AutomovilClienteFeign automovilClienteFeign;

    @Autowired
    private MotocicletaClienteFeign motocicletaClienteFeign;

    // Implemetacion de Feign
    public DTOAutomovil saveAutomovil(int idUsuario, DTOAutomovil dtoAutomovil) {
        dtoAutomovil.setIdUsuario(idUsuario);
        DTOAutomovil nuevoAutomovil = automovilClienteFeign.save(dtoAutomovil);
        return nuevoAutomovil;

    }

    public DTOMotocicleta saveMotocicleta(int idUsuario, DTOMotocicleta dtoMotocicleta){
        dtoMotocicleta.setIdUsuario(idUsuario);
        DTOMotocicleta nuevaMotocicleta = motocicletaClienteFeign.save(dtoMotocicleta);
        return nuevaMotocicleta;
    }

    public Map<String, Object> getUserAndVehiculos(int idUsuario){

        Map<String, Object> resultado = new HashMap<>();

        // busqueda del usuario y mostrarlo
        Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
        if(usuario == null){
            resultado.put("Mensaje","El usuario no existe");
            return resultado;
        } else {
            resultado.put("Usuario", usuario);
        }

        // busqueda de los automoviles por id de usuario y mostralos
        List<DTOAutomovil> autos = automovilClienteFeign.getAllAutos(idUsuario);
        if(autos.isEmpty()) {
            resultado.put("Mensaje","El usuario no tiene automoviles");
        } else {
            resultado.put("Automoviles", autos);
        }

        // busqueda de las motocicletas por id de usuario y mostrarlas
        List<DTOMotocicleta> motos = motocicletaClienteFeign.getAllMotos(idUsuario);
        if(motos.isEmpty()) {
            resultado.put("Mensaje","El usuario no tiene motocicletas");
        } else {
            resultado.put("Motocicletas", motos);
        }

        return resultado;

    }

    public List<Usuario> getAll(){
        return usuarioRepositorio.findAll();
    }

    public Usuario getById(Integer id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){ return usuarioRepositorio.save(usuario); }

    // Implementacion de RestTemplate
    public List<DTOAutomovil> getAutomovil(int idUsuario) {
        List<DTOAutomovil> automoviles = restTemplate.getForObject("http://automovil-servicio/api/automoviles/usuario/" + idUsuario, List.class);
        return automoviles;
    }

    public List<DTOMotocicleta> getMotocicletas(int idUsuario) {
        List<DTOMotocicleta> DTOMotocicletas = restTemplate.getForObject("http://motocicleta-servicio/api/motocicletas/usuario/" + idUsuario, List.class);
        return DTOMotocicletas;
    }

}
