package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.repositorios.CompraRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    CompraRepo compraRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerCompraClientesT(){

        List<Object[]> compras = compraRepo.obtenerCompraClientes();
        compras.forEach(objects -> System.out.println("nombre : " + objects[0] + "compras : " + objects[1]));
    }
}
