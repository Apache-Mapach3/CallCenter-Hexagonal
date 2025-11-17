/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.application.services;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Campana;
import com.callcenter.backend.domain.ports.in.GestionarCampanaUseCase;
import com.callcenter.backend.domain.ports.out.CampanaRepositoryPort;
import java.util.List;

// APLICACIÓN: Servicio de Negocio.
// Implementa las reglas para gestionar campañas.
public class CampanaService implements GestionarCampanaUseCase {

    private final CampanaRepositoryPort campanaRepositoryPort;

    public CampanaService(CampanaRepositoryPort campanaRepositoryPort) {
        this.campanaRepositoryPort = campanaRepositoryPort;
    }

    @Override
    public Campana crearCampana(Campana campana) {
        // Regla de negocio simple: El código de campaña debe estar en mayúsculas
        if (campana.getCodigoCampana() != null) {
            campana.setCodigoCampana(campana.getCodigoCampana().toUpperCase());
        }
        return campanaRepositoryPort.save(campana);
    }

    @Override
    public Campana obtenerCampana(Long id) {
        return campanaRepositoryPort.findById(id).orElse(null);
    }

    @Override
    public List<Campana> listarCampanas() {
        return campanaRepositoryPort.findAll();
    }
}