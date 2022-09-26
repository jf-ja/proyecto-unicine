package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.HorarioPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioPeliculaRepo extends JpaRepository<HorarioPelicula,Integer> {

}
