/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.service;

import com.bancapp.entity.Cliente;
import com.bancapp.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodo() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return cliente.get();
        }
        return null;
    }

    @Override
    public Cliente buscarPorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
    
}
