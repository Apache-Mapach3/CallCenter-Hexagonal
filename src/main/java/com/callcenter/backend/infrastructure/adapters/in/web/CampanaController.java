/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.in.web;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.domain.model.Campana;
import com.callcenter.backend.domain.ports.in.GestionarCampanaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// ADAPTADOR WEB: Expone la gestión de campañas a internet (JSON).
@RestController
@RequestMapping("/api/v1/campanas")
public class CampanaController {

    private final GestionarCampanaUseCase gestionarCampanaUseCase;

    public CampanaController(GestionarCampanaUseCase gestionarCampanaUseCase) {
        this.gestionarCampanaUseCase = gestionarCampanaUseCase;
    }

    @PostMapping
    public ResponseEntity<Campana> crear(@RequestBody Campana campana) {
        return ResponseEntity.ok(gestionarCampanaUseCase.crearCampana(campana));
    }

    @GetMapping
    public ResponseEntity<List<Campana>> listar() {
        return ResponseEntity.ok(gestionarCampanaUseCase.listarCampanas());
    }
}