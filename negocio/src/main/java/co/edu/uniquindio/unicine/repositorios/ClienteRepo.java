package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Cupon;
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
    @Query("select c from Cliente c where c.nombre = :nombre")
    Cliente obtenerClientePorNombreR(String nombre);

    @Query("select c from Cliente c where c.correo= :correo and c.password= :password")
    Cliente comprobarAutenticacionClienteR(String correo, String password);

    Cliente findByCorreoAndPassword(String correo, String password);

    @Query("select c from Cliente c where c.estado= :estado")
    List<Cliente> obtenerClientesPorEstadoR(boolean estado, Pageable paginador);

    @Query("select comp from Cliente cli, in(cli.compras) comp where cli.correo = :correo")
    List<Compra> obtenerCompraPorCorreoClienteR(String correo);

    @Query("select c from Compra c where c.cliente.correo = :correo")
    List<Compra> obtenerCompraPorCorreoCliente2R(String correo);

    @Query("select comp from Cliente cli join cli.compras comp where cli.correo = :correo")
    List<Compra> obtenerCompraPorCorreoCliente3R(String correo);

    @Query("select cup from Cliente cli join cli.cupones cup where cli.codigo = :codigo")
    List<Cupon> obtenerCuponesPorCodigoClienteR(Integer codigo);
}
