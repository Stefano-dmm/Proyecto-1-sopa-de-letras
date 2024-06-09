/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author mainp
 * 
 * Esta clase representa una ventana que muestra un gráfico utilizando el algoritmo de búsqueda en anchura (BFS).
 */
public class GraphWindowsbfs extends JFrame {
    /**
     * La lista de adyacencia que representa el gráfico.
     */
    private Map<String, Set<String>> adjacencyList;
    /**
     * La lista de vértices en el orden en que se visitaron durante la búsqueda en anchura.
     */
    private java.util.List<String> order;

    /**
     * Construye una nueva ventana de gráfico con la lista de adyacencia y el orden de visita de los vértices.
     *
     * @param order la lista de vértices en el orden en que se visitaron
     * @param adjacencyList la lista de adyacencia que representa el gráfico
     */
    public GraphWindowsbfs(java.util.List<String> order, Map<String, Set<String>> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.order = order;
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    /**
     * Pinta el gráfico en la ventana.
     *
     * @param g el objeto Graphics para proteger
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int radius = 20;
        int padding = 50;
        int vertexCount = adjacencyList.size();
        double angleStep = 2 * Math.PI / vertexCount;

        Map<String, Point> vertexLocations = new HashMap<>();
        for (int i = 0; i < order.size(); i++) {
            String vertex = order.get(i);
            int x = (int) (Math.cos(i * angleStep) * (getWidth() / 2 - padding - radius) + getWidth() / 2);
            int y = (int) (Math.sin(i * angleStep) * (getHeight() / 2 - padding - radius) + getHeight() / 2);
            vertexLocations.put(vertex, new Point(x, y));
        }

        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
            for (String edge : entry.getValue()) {
                Point p1 = vertexLocations.get(entry.getKey());
                Point p2 = vertexLocations.get(edge);
                if (p1 != null && p2 != null) {
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }

        for (Map.Entry<String, Point> entry : vertexLocations.entrySet()) {
            g2d.fillOval(entry.getValue().x - radius / 2, entry.getValue().y - radius / 2, radius, radius);
            g2d.drawString(entry.getKey(), entry.getValue().x - radius / 2, entry.getValue().y - radius / 2);
        }
    }
}