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
 * Esta clase representa una ventana que muestra un gráfico.
 */
public class GraphWindow extends JFrame {
    /**
     * La lista de adyacencia que representa el gráfico.
     */
    private Map<String, Set<String>> adjacencyList;

    /**
     * Construye una nueva ventana de gráfico.
     */
    public GraphWindow() {
        this.adjacencyList = new HashMap<>();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Agrega un vértice al gráfico.
     *
     * @param vertex el vértice a agregar
     */
    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    /**
     * Agrega un borde entre dos vértices en el gráfico.
     *
     * @param vertex1 el primer vértice
     * @param vertex2 el segundo vértice
     */
    public void addEdge(String vertex1, String vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
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
        int i = 0;
        for (String vertex : adjacencyList.keySet()) {
            int x = (int) (Math.cos(i * angleStep) * (getWidth() / 2 - padding - radius) + getWidth() / 2);
            int y = (int) (Math.sin(i * angleStep) * (getHeight() / 2 - padding - radius) + getHeight() / 2);
            vertexLocations.put(vertex, new Point(x, y));
            i++;
        }

        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
            for (String edge : entry.getValue()) {
                Point p1 = vertexLocations.get(entry.getKey());
                Point p2 = vertexLocations.get(edge);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        for (Map.Entry<String, Point> entry : vertexLocations.entrySet()) {
            g2d.fillOval(entry.getValue().x - radius / 2, entry.getValue().y - radius / 2, radius, radius);
            g2d.drawString(entry.getKey(), entry.getValue().x - radius / 2, entry.getValue().y - radius / 2);
        }
    }
}