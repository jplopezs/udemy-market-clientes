package com.udemy.market.clientes.service;

import com.udemy.market.clientes.model.Cliente;

public interface ClientesService {

    Cliente authenticateCliente(String usuario, String password);
    boolean createCliente(Cliente cliente);

}
