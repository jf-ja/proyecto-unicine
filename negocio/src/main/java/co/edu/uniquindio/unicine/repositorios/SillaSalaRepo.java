package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.SillaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillaSalaRepo extends JpaRepository<SillaSala, String> {
}
