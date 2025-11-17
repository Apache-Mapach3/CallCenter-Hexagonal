/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.domain.model;

/**
 *
 * @author Jarry
 */
// DOMINIO: Modelo de Datos.
// Representa un Agente dentro de la lógica de negocio.
// Usamos Getters y Setters manuales para asegurar compatibilidad total sin depender de librerías externas.
public class Agente {
    private Long id;
    private String nombreCompleto;
    private String numeroEmpleado;
    private String telefono;
    private String email;
    private String nivelExperiencia;

    public Agente() {}

    public Agente(Long id, String nombreCompleto, String numeroEmpleado, String telefono, String email, String nivelExperiencia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.numeroEmpleado = numeroEmpleado;
        this.telefono = telefono;
        this.email = email;
        this.nivelExperiencia = nivelExperiencia;
    }

    // --- GETTERS Y SETTERS MANUALES ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNumeroEmpleado() { return numeroEmpleado; }
    public void setNumeroEmpleado(String numeroEmpleado) { this.numeroEmpleado = numeroEmpleado; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNivelExperiencia() { return nivelExperiencia; }
    public void setNivelExperiencia(String nivelExperiencia) { this.nivelExperiencia = nivelExperiencia; }
}