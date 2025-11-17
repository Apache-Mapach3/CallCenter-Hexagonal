/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.backend.infrastructure.adapters.in.desktop;

/**
 *
 * @author  Jarry
 */
import com.callcenter.backend.domain.model.Agente;
import com.callcenter.backend.domain.model.Campana;
import com.callcenter.backend.domain.ports.in.GestionarAgenteUseCase;
import com.callcenter.backend.domain.ports.in.GestionarCampanaUseCase;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Component
public class PantallaPrincipal extends JFrame {
// Dependencias: Los casos de uso de Agente y Campaña
    private final GestionarAgenteUseCase gestionarAgenteUseCase;
    private final GestionarCampanaUseCase gestionarCampanaUseCase;
// Componentes de la Interfaz
    // --- COMPONENTES AGENTES ---
    private JTextField txtIdAgente, txtNombreAgente, txtEmpleadoAgente;
    private JTextArea areaAgentes;

    // --- COMPONENTES CAMPAÑAS ---
    private JTextField txtCodigoCampana, txtNombreCampana, txtTipoCampana, txtObjetivoCampana;
    private JTextArea areaCampanas;

    // Constructor con Doble Inyección (Agentes y Campañas)
    public PantallaPrincipal(GestionarAgenteUseCase gestionarAgenteUseCase, 
                             GestionarCampanaUseCase gestionarCampanaUseCase) {
        this.gestionarAgenteUseCase = gestionarAgenteUseCase;
        this.gestionarCampanaUseCase = gestionarCampanaUseCase;
        initUI();
    }

    private void initUI() {
        setTitle("Sistema Call Center - Gestión Integral");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. Creamos el Panel de Pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // 2. Agregamos las pestañas
        tabbedPane.addTab("Gestión de Agentes", crearPanelAgentes());
        tabbedPane.addTab("Gestión de Campañas", crearPanelCampanas());

        // 3. Agregamos el panel a la ventana
        add(tabbedPane);
    }

  
    //MÉTODOS PARA CONSTRUIR EL PANEL DE AGENTES
   
    private JPanel crearPanelAgentes() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de Formulario (Grid Layout para organizar campos)
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Datos del Agente"));
        
        form.add(new JLabel("ID (Para Editar/Borrar):"));
        txtIdAgente = new JTextField();
        form.add(txtIdAgente);

        form.add(new JLabel("Nombre Completo:"));
        txtNombreAgente = new JTextField();
        form.add(txtNombreAgente);

        form.add(new JLabel("N° Empleado:"));
        txtEmpleadoAgente = new JTextField();
        form.add(txtEmpleadoAgente);

        // Panel de Botones con Listeners (Acciones)
        JPanel botones = new JPanel();
        JButton btnCrear = new JButton("Guardar Agente");
        JButton btnListar = new JButton("Listar Agentes");
        JButton btnEliminar = new JButton("Eliminar Agente");

        // Conexión Botón -> Lógica de Negocio
        btnCrear.addActionListener(e -> guardarAgente());
        btnListar.addActionListener(e -> listarAgentes());
        btnEliminar.addActionListener(e -> eliminarAgente());

        botones.add(btnCrear);
        botones.add(btnListar);
        botones.add(btnEliminar);

        // Area Resultados Agentes
        areaAgentes = new JTextArea();
        areaAgentes.setEditable(false);
        areaAgentes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaAgentes), BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
    }
// Lógica de interacción con el Servicio de Agentes
    private void guardarAgente() {
        try {
            Agente a = new Agente();
            a.setNombreCompleto(txtNombreAgente.getText());
            a.setNumeroEmpleado(txtEmpleadoAgente.getText());
            a.setEmail("mail@test.com");
            a.setNivelExperiencia("Junior");
            // Llamada al Puerto de Entrada
            Agente nuevo = gestionarAgenteUseCase.crearAgente(a);
            showMessage("Agente creado ID: " + nuevo.getId());
            listarAgentes();
            limpiarCamposAgente();
        } catch (Exception e) { showMessage("Error: " + e.getMessage()); }
    }

    private void listarAgentes() {
        List<Agente> lista = gestionarAgenteUseCase.listarAgentes();
        areaAgentes.setText("--- AGENTES REGISTRADOS ---\n");
        for(Agente a : lista) {
            areaAgentes.append("ID: " + a.getId() + " | " + a.getNombreCompleto() + " | Emp: " + a.getNumeroEmpleado() + "\n");
        }
    }

    private void eliminarAgente() {
        try {
            if(txtIdAgente.getText().isEmpty()) {
                showMessage("Escribe un ID para eliminar");
                return;
            }
            Long id = Long.parseLong(txtIdAgente.getText());
            gestionarAgenteUseCase.eliminarAgente(id);
            showMessage("Agente eliminado");
            listarAgentes();
            limpiarCamposAgente();
        } catch (Exception e) { showMessage("Error al eliminar: " + e.getMessage()); }
    }
    
    private void limpiarCamposAgente() {
        txtIdAgente.setText("");
        txtNombreAgente.setText("");
        txtEmpleadoAgente.setText("");
    }

    //MÉTODOS PARA CONSTRUIR EL PANEL DE CAMPAÑA
    private JPanel crearPanelCampanas() {
        JPanel panel = new JPanel(new BorderLayout());

        // Formulario Campañas
        JPanel form = new JPanel(new GridLayout(5, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Datos de Campaña"));

        form.add(new JLabel("Código :"));
        txtCodigoCampana = new JTextField();
        form.add(txtCodigoCampana);

        form.add(new JLabel("Nombre Campaña:"));
        txtNombreCampana = new JTextField();
        form.add(txtNombreCampana);

        form.add(new JLabel("Tipo (Ventas/Soporte):"));
        txtTipoCampana = new JTextField();
        form.add(txtTipoCampana);

        form.add(new JLabel("Objetivo:"));
        txtObjetivoCampana = new JTextField();
        form.add(txtObjetivoCampana);

        // Botones Campañas
        JPanel botones = new JPanel();
        JButton btnCrear = new JButton("Guardar Campaña");
        btnCrear.setBackground(new Color(173, 216, 230)); // Azul claro
        JButton btnListar = new JButton("Ver Campañas");

        btnCrear.addActionListener(e -> guardarCampana());
        btnListar.addActionListener(e -> listarCampanas());

        botones.add(btnCrear);
        botones.add(btnListar);

        // Area Resultados Campañas
        areaCampanas = new JTextArea();
        areaCampanas.setEditable(false);
        areaCampanas.setFont(new Font("Monospaced", Font.PLAIN, 12));

        panel.add(form, BorderLayout.NORTH);
        panel.add(new JScrollPane(areaCampanas), BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
    }

    private void guardarCampana() {
        try {
            Campana c = new Campana();
            c.setCodigoCampana(txtCodigoCampana.getText());
            c.setNombre(txtNombreCampana.getText());
            c.setTipo(txtTipoCampana.getText());
            c.setObjetivo(txtObjetivoCampana.getText());
            c.setFechaInicio(LocalDate.now());
            c.setFechaFin(LocalDate.now().plusMonths(1));
           // Llamada al Puerto de Entrada de Campañas 
            Campana nueva = gestionarCampanaUseCase.crearCampana(c);
            showMessage("Campaña creada: " + nueva.getNombre());
            listarCampanas();
            limpiarCamposCampana();
        } catch (Exception e) { showMessage("Error: " + e.getMessage()); }
    }

    private void listarCampanas() {
        List<Campana> lista = gestionarCampanaUseCase.listarCampanas();
        areaCampanas.setText("--- CAMPAÑAS ACTIVAS ---\n");
        for(Campana c : lista) {
            areaCampanas.append("COD: " + c.getCodigoCampana() + " | " + c.getNombre() + " | Tipo: " + c.getTipo() + "\n");
        }
    }
    
    private void limpiarCamposCampana() {
        txtCodigoCampana.setText("");
        txtNombreCampana.setText("");
        txtTipoCampana.setText("");
        txtObjetivoCampana.setText("");
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}