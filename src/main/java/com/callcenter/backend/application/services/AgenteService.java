/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.application.services;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Agente;
import com.callcenter.backend.domain.ports.in.GestionarAgenteUseCase;
import com.callcenter.backend.domain.ports.out.AgenteRepositoryPort;
import java.util.List;
// APLICACIÓN: Servicio de Agente.
// Implementa el caso de uso (GestionarAgenteUseCase).
// Esta clase coordina la lógica: recibe datos, valida y llama al repositorio.
public class AgenteService implements GestionarAgenteUseCase {

    private final AgenteRepositoryPort agenteRepositoryPort;
// Inyección por Constructor: Recibe cualquier implementación del repositorio
    public AgenteService(AgenteRepositoryPort agenteRepositoryPort) {
        this.agenteRepositoryPort = agenteRepositoryPort;
    }

    @Override
    public Agente crearAgente(Agente agente) {
        return agenteRepositoryPort.save(agente);
    }

    @Override
    public Agente actualizarAgente(Long id, Agente agente) {
        if (agenteRepositoryPort.findById(id).isPresent()) {
            agente.setId(id);
            return agenteRepositoryPort.save(agente);
        }
        return null; // O lanzar excepción
    }

    @Override
    public Agente obtenerAgente(Long id) {
        return agenteRepositoryPort.findById(id).orElse(null);
    }

    @Override
    public List<Agente> listarAgentes() {
        return agenteRepositoryPort.findAll();
    }
    
    @Override
    public void eliminarAgente(Long id) {
        // Llamamos al puerto de salida para borrar
        agenteRepositoryPort.deleteById(id);
    }
}