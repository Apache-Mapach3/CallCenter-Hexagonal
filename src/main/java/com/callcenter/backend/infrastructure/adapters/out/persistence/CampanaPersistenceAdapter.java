/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.out.persistence;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Campana;
import com.callcenter.backend.domain.ports.out.CampanaRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// ADAPTADOR: El Traductor.
// Convierte de Campana (Dominio) a CampanaEntity (BD) y viceversa.
@Component
public class CampanaPersistenceAdapter implements CampanaRepositoryPort {

    private final SpringDataCampanaRepository springRepository;

    public CampanaPersistenceAdapter(SpringDataCampanaRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Campana save(Campana campana) {
        // Convertir Dominio a Entidad
        CampanaEntity entity = new CampanaEntity();
        entity.setId(campana.getId());
        entity.setCodigoCampana(campana.getCodigoCampana());
        entity.setNombre(campana.getNombre());
        entity.setTipo(campana.getTipo());
        entity.setFechaInicio(campana.getFechaInicio());
        entity.setFechaFin(campana.getFechaFin());
        entity.setObjetivo(campana.getObjetivo());

        // Guardar en BD
        CampanaEntity saved = springRepository.save(entity);

        // Convertir Entidad a Dominio y retornar
        return new Campana(saved.getId(), saved.getCodigoCampana(), saved.getNombre(), saved.getTipo(), saved.getFechaInicio(), saved.getFechaFin(), saved.getObjetivo());
    }

    @Override
    public Optional<Campana> findById(Long id) {
        return springRepository.findById(id)
                .map(e -> new Campana(e.getId(), e.getCodigoCampana(), e.getNombre(), e.getTipo(), e.getFechaInicio(), e.getFechaFin(), e.getObjetivo()));
    }

    @Override
    public List<Campana> findAll() {
        return springRepository.findAll().stream()
                .map(e -> new Campana(e.getId(), e.getCodigoCampana(), e.getNombre(), e.getTipo(), e.getFechaInicio(), e.getFechaFin(), e.getObjetivo()))
                .collect(Collectors.toList());
    }
}