/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imprimir;

import org.graphstream.graph.implementations.*;

public class GraphPrinter {
    public static void main(String args[]) {
        System.setProperty("org.graphstream.ui", "swing");
        
        SingleGraph graph = new SingleGraph("My Graph");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        graph.display();
    }
}