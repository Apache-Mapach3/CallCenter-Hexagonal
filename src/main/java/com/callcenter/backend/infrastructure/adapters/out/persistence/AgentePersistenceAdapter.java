/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.out.persistence;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Agente;
import com.callcenter.backend.domain.ports.out.AgenteRepositoryPort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// ADAPTADOR DE SALIDA: Implementa el puerto definido por el dominio.
// Actúa como traductor: Recibe objetos del Dominio (Agente) y los convierte a Entidades de BD (AgenteEntity).
@Component
public class AgentePersistenceAdapter implements AgenteRepositoryPort {

    private final SpringDataAgenteRepository springRepository;

    // Inyección de dependencia del repositorio de Spring
    public AgentePersistenceAdapter(SpringDataAgenteRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Agente save(Agente agente) {
        //  MAPEO: Convertir Dominio -> Entidad BD
        AgenteEntity entity = new AgenteEntity();
        entity.setId(agente.getId());
        entity.setNombreCompleto(agente.getNombreCompleto());
        entity.setNumeroEmpleado(agente.getNumeroEmpleado());
        entity.setTelefono(agente.getTelefono());
        entity.setEmail(agente.getEmail());
        entity.setNivelExperiencia(agente.getNivelExperiencia());

        // PERSISTENCIA: Guardar usando Spring Data
        AgenteEntity saved = springRepository.save(entity);

        // RETORNO: Convertir Entidad BD -> Dominio
        return new Agente(
                saved.getId(),
                saved.getNombreCompleto(),
                saved.getNumeroEmpleado(),
                saved.getTelefono(),
                saved.getEmail(),
                saved.getNivelExperiencia()
        );
    }

    @Override
    public Optional<Agente> findById(Long id) {
        // Busca en la BD y si encuentra, mapea a objeto de dominio
        return springRepository.findById(id)
                .map(entity -> new Agente(
                        entity.getId(),
                        entity.getNombreCompleto(),
                        entity.getNumeroEmpleado(),
                        entity.getTelefono(),
                        entity.getEmail(),
                        entity.getNivelExperiencia()
                ));
    }

    @Override
    public List<Agente> findAll() {
        // Convierte la lista de entidades a lista de modelos de dominio
        return springRepository.findAll().stream()
                .map(entity -> new Agente(
                        entity.getId(),
                        entity.getNombreCompleto(),
                        entity.getNumeroEmpleado(),
                        entity.getTelefono(),
                        entity.getEmail(),
                        entity.getNivelExperiencia()
                ))
                .collect(Collectors.toList());
    }  
        @Override
    public void deleteById(Long id) {
        springRepository.deleteById(id);
    
    }
}