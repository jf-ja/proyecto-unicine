package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.repositorios.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuponTest {


    @Autowired
    CuponRepo cuponRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClientePorCuponT(){

        String nombreCliente = cuponRepo.obtenerClientePorCuponR(200);
        System.out.println(nombreCliente);
        Assertions.assertEquals("Laura" , nombreCliente);


    }
}
