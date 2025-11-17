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
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campana {
    private Long id;
    private String codigoCampana;
    private String nombre;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
}
