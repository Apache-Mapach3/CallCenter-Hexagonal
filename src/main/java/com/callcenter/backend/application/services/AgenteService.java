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

// APLICACIÓN: Implementación del Caso de Uso.
// Contiene la lógica de negocio pura. Coordina los puertos.
// No tiene anotaciones de Spring (@Service) para mantener la pureza de la arquitectura.
public class AgenteService implements GestionarAgenteUseCase {

    private final AgenteRepositoryPort agenteRepositoryPort;

    // Inyección por constructor del puerto de salida (Base de datos)
    public AgenteService(AgenteRepositoryPort agenteRepositoryPort) {
        this.agenteRepositoryPort = agenteRepositoryPort;
    }

    @Override
    public Agente crearAgente(Agente agente) {
        // Aquí irían validaciones de negocio Ejemplo: validar formato de email
        return agenteRepositoryPort.save(agente);
    }

    @Override
    public Agente actualizarAgente(Long id, Agente agente) {
        if (agenteRepositoryPort.findById(id).isPresent()) {
            agente.setId(id);
            return agenteRepositoryPort.save(agente);
        }
        return null;
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
        // Lógica para eliminar
    }
}