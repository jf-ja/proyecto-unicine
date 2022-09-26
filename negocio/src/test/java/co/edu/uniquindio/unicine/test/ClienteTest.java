package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("32121213");
        telefonos.add("31285949");
        Cliente cliente = new Cliente("Felipe", "feli@email.com", "felipe123", "felipefoto", false, telefonos);
        Cliente guardado = clienteRepo.save(cliente);
        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar() {


        Cliente guardado = clienteRepo.findById(2222).orElse(null);
        clienteRepo.delete(guardado);
        Assertions.assertNull(clienteRepo.findById(2222).orElse(null));

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar() {

        Cliente guardado = clienteRepo.findById(2222).orElse(null);
        guardado.setCorreo("cami@gmail.com");
        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertEquals("cami@gmail.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener() {

        Optional<Cliente> buscado = clienteRepo.findById(1111);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar() {

        List<Cliente> lista = clienteRepo.findAll();
        System.out.println(lista);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClientePorCorreoT() {
        Cliente cliente = clienteRepo.obtenerClientePorCorreoR("cliente2@gmail.com");
        System.out.println(cliente);
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacionClienteT(){
        Cliente cliente = clienteRepo.comprobarAutenticacionClienteR("cliente2@gmail.com", "Ca");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorClientesT(){
        List<Cliente> clientes = clienteRepo.findAll(PageRequest.of(1, 2)).toList();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void paginadorClientesPorEstadoT(){
        List<Cliente> clientes = clienteRepo.obtenerClientesPorEstadoR(false, PageRequest.of(0, 2 , Sort.by("nombre")));
        clientes.forEach(System.out::println);
    }
}
