package com.bancapp;

import com.bancapp.entity.Cliente;
import com.bancapp.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BancappApplicationTests {

    @Autowired
    ClienteService clienteService;

    @Test
    void contextLoads() {
        Cliente cliente = clienteService.buscarPorNombre("Clara");
        System.out.println("cliente = " + cliente);
    }

}
