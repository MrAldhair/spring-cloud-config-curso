package com.motocicleta.servicio.repositorios;

import com.motocicleta.servicio.entidades.Motocicleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotocicletaRepositorio extends JpaRepository<Motocicleta, Integer> {

    @Query("SELECT f FROM Motocicleta f WHERE LOWER(f.idUsuario) = LOWER(:idUsuario)")
    List<Motocicleta> findMotoByIdUser(@Param("idUsuario") Integer idUsuario);
}
