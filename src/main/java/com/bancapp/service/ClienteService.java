/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.service;

import com.bancapp.entity.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> listarTodo();
    
    public Cliente buscarPorId(Long id);
    public Cliente buscarPorNombre(String nombre);
    
}
