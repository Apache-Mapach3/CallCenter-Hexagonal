/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.callcenter.backend.domain.ports.out;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Agente;
import java.util.List;
import java.util.Optional;

// PUERTO DE SALIDA (Output Port):
// Define lo que el dominio NECESITA que haga la infraestructura.
// El dominio dice "Necesito guardar un agente", pero no le importa si es en MySQL, Oracle o un archivo.
public interface AgenteRepositoryPort {
    Agente save(Agente agente);
    Optional<Agente> findById(Long id);
    List<Agente> findAll();
    // void deleteById(Long id);
}