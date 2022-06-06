package com.automovil.servicio.repositorios;

import com.automovil.servicio.entidades.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutomovilRepositorio extends JpaRepository<Automovil,Integer> {

    @Query("SELECT f FROM Automovil f WHERE LOWER(f.idUsuario) = LOWER(:idUsuario)")
    List<Automovil> findAutoByIdUser(@Param("idUsuario") Integer idUsuario);

}
