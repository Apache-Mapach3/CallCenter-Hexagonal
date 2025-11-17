/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.callcenter.backend.domain.ports.in;

/**
 *
 * @author Jarry
 */

import com.callcenter.backend.domain.model.Agente;
import java.util.List;

// PUERTO DE ENTRADA (Input Port):
// Define el "contrato" o las operaciones que el núcleo de la aplicación ofrece al mundo exterior.
// Los controladores (API) usarán esta interfaz, sin saber cómo se implementa por detrás.
public interface GestionarAgenteUseCase {
    Agente crearAgente(Agente agente);
    Agente actualizarAgente(Long id, Agente agente);
    Agente obtenerAgente(Long id);
    List<Agente> listarAgentes();
    void eliminarAgente(Long id);
}