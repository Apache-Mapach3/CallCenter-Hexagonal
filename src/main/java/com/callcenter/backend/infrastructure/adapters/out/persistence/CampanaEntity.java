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
import java.time.LocalDate;

// INFRAESTRUCTURA: Entidad de Base de Datos.
// Mapea los datos de las campañas a una tabla SQL llamada "campanas".
@Entity
@Table(name = "campanas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampanaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigoCampana; // Ejemplo: CAMP-001

    private String nombre;
    private String tipo; // Ventas, Soporte, Cobranza
    
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
}