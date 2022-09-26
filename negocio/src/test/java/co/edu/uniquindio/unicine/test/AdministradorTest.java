package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repositorios.AdministradorRepo;
import co.edu.uniquindio.unicine.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        Administrador administrador = new Administrador("Paco" , "paco@gmail.com", "paco123");
        Administrador guardado= administradorRepo.save(administrador);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        Administrador guardado= administradorRepo.findById(02).orElse(null);
        administradorRepo.delete(guardado);
        Assertions.assertNull(administradorRepo.findById(02).orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Administrador guardado = administradorRepo.findById(02).orElse(null);
        guardado.setCorreo("sandra@gmail.com");
        Administrador nuevo = administradorRepo.save(guardado);

        Assertions.assertEquals("sandra@gmail.com", nuevo.getCorreo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Administrador> buscado = administradorRepo.findById(1111);
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Administrador> lista = administradorRepo.findAll();
        System.out.println(lista);

    }
}
