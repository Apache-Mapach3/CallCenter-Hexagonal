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
import com.callcenter.backend.application.services.CampanaService;
import com.callcenter.backend.domain.ports.in.GestionarAgenteUseCase;
import com.callcenter.backend.domain.ports.in.GestionarCampanaUseCase;
import com.callcenter.backend.domain.ports.out.AgenteRepositoryPort;
import com.callcenter.backend.domain.ports.out.CampanaRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// INFRAESTRUCTURA: Configuración de Beans de Spring.
// Como nuestras clases de Dominio/Aplicación no tienen anotaciones @Service (para mantenerlas puras),
// aquí las instanciamos manualmente y les inyectamos sus dependencias.
@Configuration
public class BeanConfiguration {
// Inyección del Servicio de Agentes
    @Bean
    public GestionarAgenteUseCase gestionarAgenteUseCase(AgenteRepositoryPort repositoryPort) {
        return new AgenteService(repositoryPort);
    }
// Inyección del Servicio de Campañas
    @Bean
    public GestionarCampanaUseCase gestionarCampanaUseCase(CampanaRepositoryPort repositoryPort) {
        return new CampanaService(repositoryPort);
    }
}