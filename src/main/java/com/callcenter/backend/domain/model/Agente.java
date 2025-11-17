/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.domain.model;

/**
 *
 * @author Jarry
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DOMINIO: Modelo puro de negocio.
// Esta clase representa la entidad "Agente" dentro de la lógica del sistema.
// NOTA: No tiene anotaciones de base de datos (@Entity) para mantenerse desacoplada.
@Data // Lombok: Genera automáticamente Getters, Setters, toString, etc.
@AllArgsConstructor // Lombok: Constructor con todos los argumentos
@NoArgsConstructor  // Lombok: Constructor vacío
public class Agente {
    private Long id;
    private String nombreCompleto;
    private String numeroEmpleado; // Identificador único corporativo
    private String telefono;
    private String email;
    private String nivelExperiencia; // Junior, Intermedio, Senior
}