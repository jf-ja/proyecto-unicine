package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer>  {

    @Query("select c from Cliente c where c.correo = :email")
    Cliente obtenerClientePorCorreoR(String email);

    Cliente findByCorreo(String email);

    @Query("select c from Cliente c where c.correo= :correo and c.password= :password")
    Cliente comprobarAutenticacionClienteR(String correo, String password);

    Cliente findByCorreoAndPassword(String correo, String password);

    @Query("select c from Cliente c where c.estado= :estado")
    List<Cliente> obtenerClientesPorEstadoR(boolean estado, Pageable paginador);
}
