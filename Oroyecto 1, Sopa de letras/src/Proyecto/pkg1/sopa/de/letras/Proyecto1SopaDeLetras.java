/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto.pkg1.sopa.de.letras;
import javax.swing.JFrame;

/**
 *
 * @author mainp
 * Clase principal del proyecto de la sopa de letras.
 */
public class Proyecto1SopaDeLetras {
 /**
     * Punto de entrada del programa.
     * Crea una nueva instancia de la ventana de entrada y la muestra al usuario.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Crear una nueva instancia de la ventana de entrada
        VentanaInput ventana = new VentanaInput();

        // Configurar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 500);
        ventana.setVisible(true);
    }
    
}
