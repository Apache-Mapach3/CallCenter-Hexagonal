/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.callcenter.backend.domain.ports.in;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Campana;
import java.util.List;

public interface GestionarCampanaUseCase {
    Campana crearCampana(Campana campana);
    Campana obtenerCampana(Long id);
    List<Campana> listarCampanas();
}