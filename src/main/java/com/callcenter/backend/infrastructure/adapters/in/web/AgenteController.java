/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.in.web;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Agente;
import com.callcenter.backend.domain.ports.in.GestionarAgenteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// ADAPTADOR DE ENTRADA: Controlador REST.
// Expone los endpoints HTTP para que el frontend o Postman puedan interactuar con el sistema.
@RestController
@RequestMapping("/api/v1/agentes")
public class AgenteController {

    private final GestionarAgenteUseCase gestionarAgenteUseCase;

    // Solo interactúa con el Puerto de Entrada, desconoce la implementación interna.
    public AgenteController(GestionarAgenteUseCase gestionarAgenteUseCase) {
        this.gestionarAgenteUseCase = gestionarAgenteUseCase;
    }

    @PostMapping
    public ResponseEntity<Agente> crearAgente(@RequestBody Agente agente) {
        Agente nuevoAgente = gestionarAgenteUseCase.crearAgente(agente);
        return new ResponseEntity<>(nuevoAgente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agente>> listarAgentes() {
        return ResponseEntity.ok(gestionarAgenteUseCase.listarAgentes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agente> obtenerAgente(@PathVariable Long id) {
        Agente agente = gestionarAgenteUseCase.obtenerAgente(id);
        if (agente != null) {
            return ResponseEntity.ok(agente);
        }
        return ResponseEntity.notFound().build();
    }
}