/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import javax.swing.*;
import java.awt.*;
//import org.jgrapht.*;
//import org.jgrapht.graph.*;
//import org.jgrapht.ext.*;


/**
 *
 * @author mainp
 */

/**
 * Clase GraphWindow para mostrar una ventana con un grafo.
 */
public class GraphWindow extends JFrame {
    private JTextArea textArea;

    /**
     * Constructor para la clase GraphWindow.
     */
    public GraphWindow() {
        setTitle("Graph Traversal");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Método para mostrar el grafo en la ventana.
     *
     * @param graph Cadena que representa el grafo.
     */
    public void showGraph(String graph) {
        textArea.setText(graph);
        setVisible(true);
    }

    // Método para mostrar el grafo en la ventana.
    // Este método está comentado porque falta el graficador de grafos.
    // 
    // public void showGraph(Grafo grafo) {
    //     JFrame graphFrame = new JFrame("Graph Visualization");
    //     graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     graphFrame.setSize(500, 500);
    //
    //     Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);
    //
    //     // Añadir vértices al grafo
    //     for (String word : grafo.getWords()) {
    //         g.addVertex(word);
    //     }
    //
    //     // Añadir aristas al grafo
    //     for (String[] edge : grafo.getEdges()) {
    //         g.addEdge(edge[0], edge[1]);
    //     }
    //
    //     // Crear visualización del grafo
    //     JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<>(g);
    //     mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
    //     layout.execute(graphAdapter.getDefaultParent());
    //
    //     // Añadir visualización del grafo al frame
    //     graphFrame.add(new mxGraphComponent(graphAdapter));
    //     graphFrame.revalidate();
    //     graphFrame.setVisible(true);
    // }
}