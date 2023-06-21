package com.udemy.market.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.market.clientes.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente,Integer> {

    Cliente findByUsuario(String usuario);
    Cliente findByUsuarioAndPassword(String usuario, String password);

}
