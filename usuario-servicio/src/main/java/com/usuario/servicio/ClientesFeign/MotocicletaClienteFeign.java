package com.usuario.servicio.ClientesFeign;

import com.usuario.servicio.dto.DTOMotocicleta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="motocicleta-servicio"/*, url = "http://localhost:9003/api/motocicletas"*/)
public interface MotocicletaClienteFeign {

    @PostMapping("/nuevaMotocicleta")
    public DTOMotocicleta save(@RequestBody DTOMotocicleta DTOMotocicleta);

    @GetMapping("/usuario/{idUsuario}")
    public List<DTOMotocicleta> getAllMotos(@PathVariable int idUsuario);

}
