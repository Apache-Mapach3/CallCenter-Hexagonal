/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.domain.model;

/**
 *
 * @author Jarry
 */
import java.time.LocalDate;
// DOMINIO: Modelo de Campaña.
// Define qué datos componen una campaña de marketing/soporte.
public class Campana {
    private Long id;
    private String codigoCampana;
    private String nombre;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;

    public Campana() {}
// Getters y Setters
    public Campana(Long id, String codigoCampana, String nombre, String tipo, LocalDate fechaInicio, LocalDate fechaFin, String objetivo) {
        this.id = id;
        this.codigoCampana = codigoCampana;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objetivo = objetivo;
    }

    // --- GETTERS Y SETTERS MANUALES ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigoCampana() { return codigoCampana; }
    public void setCodigoCampana(String codigoCampana) { this.codigoCampana = codigoCampana; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
}