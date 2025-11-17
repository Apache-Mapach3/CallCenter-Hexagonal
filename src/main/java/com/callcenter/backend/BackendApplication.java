package com.callcenter.backend;

import com.callcenter.backend.infrastructure.adapters.in.desktop.PantallaPrincipal;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import java.awt.EventQueue;

@SpringBootApplication
public class BackendApplication {
// PUNTO DE ENTRADA:
// Inicializa Spring Boot y la interfaz gráfica
    public static void main(String[] args) {
        // Configuración para permitir interfaz gráfica (Headless = false)
        ConfigurableApplicationContext context = new SpringApplicationBuilder(BackendApplication.class)
                .headless(false) 
                .run(args);

        // Obtenemos la ventana desde Spring (para que venga con el servicio inyectado)
        EventQueue.invokeLater(() -> {
            // Obtenemos la ventana desde el contexto de Spring (ya con dependencias inyectadas)
            PantallaPrincipal ventana = context.getBean(PantallaPrincipal.class);
            ventana.setVisible(true);
        });
    }
}