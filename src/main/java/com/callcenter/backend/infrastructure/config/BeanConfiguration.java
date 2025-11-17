/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.config;

/**
 *
 * @author Jarry
 */
import com.callcenter.backend.application.services.AgenteService;
import com.callcenter.backend.domain.ports.in.GestionarAgenteUseCase;
import com.callcenter.backend.domain.ports.out.AgenteRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// CONFIGURACIÓN: Inyección de Dependencias manual.
// Aquí le "enseñamos" a Spring cómo crear los servicios del dominio
// ya que ellos no tienen anotaciones @Service.
@Configuration
public class BeanConfiguration {

    @Bean
    public GestionarAgenteUseCase gestionarAgenteUseCase(AgenteRepositoryPort repositoryPort) {
        // Inyectamos el adaptador de persistencia en el servicio de dominio
        return new AgenteService(repositoryPort);
    }
}