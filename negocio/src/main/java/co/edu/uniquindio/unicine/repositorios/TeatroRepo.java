package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeatroRepo extends JpaRepository<Teatro, String> {

    @Query("select teatro from Teatro teatro where teatro.ciudad.nombre = :nombreCiudad")
    List<Teatro> listarTeatrosPorCiudadR(String nombreCiudad);
}
