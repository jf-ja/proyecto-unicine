package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repositorios.TeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {

    @Autowired
    private TeatroRepo teatroRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        Ciudad ciudad= new Ciudad("7","Barranquilla");
        Administrador administrador = new Administrador("Paco" , "paco@gmail.com", "paco123");
        Teatro teatro= new Teatro("5", "UniFamilia" , "Av 34-Norte", ciudad,administrador);
        Teatro guardado= teatroRepo.save(teatro);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        Teatro guardado= teatroRepo.findById("2").orElse(null);
        teatroRepo.delete(guardado);
        Assertions.assertNull(teatroRepo.findById("2").orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Teatro guardado = teatroRepo.findById("2").orElse(null);
        guardado.setNombre("UniVision");
        Teatro nuevo = teatroRepo.save(guardado);

        Assertions.assertEquals("UniVision", nuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Teatro> buscado = teatroRepo.findById("2");
        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Teatro> lista = teatroRepo.findAll();
        System.out.println(lista);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTeatroPorCiudadT(){

        List<Teatro> teatros = teatroRepo.listarTeatrosPorCiudadR("Armenia");
        teatros.forEach(System.out::println);

    }

}
