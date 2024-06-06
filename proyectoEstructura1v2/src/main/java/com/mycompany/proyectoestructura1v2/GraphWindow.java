package com.mycompany.proyectoestructura1v2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author mainp
 */

//solo abre ventana, falta el graficador de grafos

public class GraphWindow extends JFrame {
    private JTextArea textArea;

    public GraphWindow() {
        setTitle("Graph Traversal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void showGraph(String graph) {
        textArea.setText(graph);
        setVisible(true);
    }
}