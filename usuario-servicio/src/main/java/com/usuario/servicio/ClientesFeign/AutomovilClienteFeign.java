package com.usuario.servicio.ClientesFeign;

import com.usuario.servicio.dto.DTOAutomovil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "automovil-servicio"/*, url = "http://localhost:9002/api/automoviles"*/)
//@RequestMapping("/automoviles") esta notacion por algun motivo ya no funciona, investigar en la documentación el porque
public interface AutomovilClienteFeign {

    @PostMapping("/nuevoAutomovil")
    public DTOAutomovil save(@RequestBody DTOAutomovil DTOAutomovil);

    @GetMapping("/usuario/{idUsuario}")
    public List<DTOAutomovil> getAllAutos(@PathVariable int idUsuario);

}
