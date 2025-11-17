/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.out.persistence;

/**
 *
 * @author Jarry
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// INFRAESTRUCTURA: Interfaz de Spring Data JPA.
// Hereda de JpaRepository para obtener métodos CRUD (save, findAll, etc.) automáticamente.
// Funciona como un "ayudante" para el adaptador.
@Repository
public interface SpringDataAgenteRepository extends JpaRepository<AgenteEntity, Long> {
    // Aquí se pueden definir consultas personalizadas SQL si hicieran falta.
}