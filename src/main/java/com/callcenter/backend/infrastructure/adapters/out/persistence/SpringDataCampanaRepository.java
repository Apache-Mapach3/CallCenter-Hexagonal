/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.out.persistence;

/**
 *
 * @author Jarry
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// INFRAESTRUCTURA: Repositorio JPA.
// Nos da los métodos save(), findAll(), findById() automáticamente.
@Repository
public interface SpringDataCampanaRepository extends JpaRepository<CampanaEntity, Long> {
}