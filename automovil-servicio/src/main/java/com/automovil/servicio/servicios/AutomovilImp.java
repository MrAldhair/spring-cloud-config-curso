package com.automovil.servicio.servicios;

import com.automovil.servicio.entidades.Automovil;
import com.automovil.servicio.repositorios.AutomovilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilImp {

    @Autowired
    private AutomovilRepositorio automovilRepositorio;

    public List<Automovil> getAll(){
        return automovilRepositorio.findAll();
    }

    public Automovil getById(Integer idAutomovil){

        return automovilRepositorio.findById(idAutomovil).orElse(null);
    }

    public Automovil save(Automovil automovil){

        return automovilRepositorio.save(automovil);
    }

    public List<Automovil> findAutoByIdUser (int idUsuario) {
        return automovilRepositorio.findAutoByIdUser(idUsuario);

    }

}
