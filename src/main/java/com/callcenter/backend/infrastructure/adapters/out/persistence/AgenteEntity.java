/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.out.persistence;

/**
 *
 * @author Jarry
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// INFRAESTRUCTURA: Entidad JPA.
// Esta clase SÍ conoce la base de datos. Mapea la tabla "agentes" de SQL.
@Entity
@Table(name = "agentes") // Nombre de la tabla en la BD
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;

    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @Column(name = "numero_empleado", unique = true, nullable = false)
    private String numeroEmpleado;

    private String telefono;
    private String email;
    
    @Column(name = "nivel_experiencia")
    private String nivelExperiencia;
}