package com.udemy.market.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.market.clientes.model.Cliente;
import com.udemy.market.clientes.repository.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Cliente authenticateCliente(String usuario, String password) {

        return clientesRepository.findByUsuarioAndPassword(usuario, password);

    }

    @Override
    public boolean createCliente(Cliente cliente) {

        if (clientesRepository.findByUsuario(cliente.getUsuario()) != null) {
            return false;
        }

        clientesRepository.save(cliente);
        return true;

    }

    

}
