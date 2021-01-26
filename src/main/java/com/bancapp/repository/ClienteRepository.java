/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancapp.repository;

import com.bancapp.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public Cliente findByNombre(String nombre);
}
