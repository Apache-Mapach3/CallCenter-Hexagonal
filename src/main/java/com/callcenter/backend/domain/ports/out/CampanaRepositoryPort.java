/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.callcenter.backend.domain.ports.out;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Campana;
import java.util.List;
import java.util.Optional;

public interface CampanaRepositoryPort {
    Campana save(Campana campana);
    Optional<Campana> findById(Long id);
    List<Campana> findAll();
}