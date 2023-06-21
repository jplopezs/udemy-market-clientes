package com.udemy.market.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.market.clientes.model.Cliente;
import com.udemy.market.clientes.service.ClientesService;

@RestController
@RequestMapping("market/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @GetMapping(value="authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> authenticate(@RequestParam("usuario") String usuario, @RequestParam("password") String password) {

        Cliente cliente = clientesService.authenticateCliente(usuario, password);
        if (cliente == null) {
            return new ResponseEntity<Cliente>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }

    }

    @PostMapping(value="create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Cliente cliente) {

        if (clientesService.createCliente(cliente) == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
