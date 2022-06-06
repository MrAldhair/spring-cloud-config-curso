package com.motocicleta.servicio.servicios;

import com.motocicleta.servicio.entidades.Motocicleta;
import com.motocicleta.servicio.repositorios.MotocicletaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotocicletaImpl {

    @Autowired
    private MotocicletaRepositorio motocicletaRepositorio;

    public List<Motocicleta> getAll(){
        return motocicletaRepositorio.findAll();
    }

    public Motocicleta getById(Integer idMotocicleta){
        return motocicletaRepositorio.findById(idMotocicleta).orElse(null);
    }

    public Motocicleta save(Motocicleta automovil){
        return motocicletaRepositorio.save(automovil);
    }

    public List<Motocicleta> findMotoByUser (int idUsuario) {
        return motocicletaRepositorio.findMotoByIdUser(idUsuario);

    }

}
