/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author mainp
 */

/**
 * Clase Grafo para representar un grafo de palabras.
 */
public class Grafo {
    private Map<String, Set<String>> adjacencyList = new HashMap<>();

    /**
     * Método para agregar un vértice al grafo.
     *
     * @param word Palabra que se agregará como vértice.
     */
    public void addVertex(String word) {
        adjacencyList.putIfAbsent(word, new LinkedHashSet<>());
    }

    /**
     * Método para agregar una arista entre dos palabras en el grafo.
     *
     * @param word1 Primera palabra de la arista.
     * @param word2 Segunda palabra de la arista.
     */
    public void addEdge(String word1, String word2) {
        if (adjacencyList.containsKey(word1) && adjacencyList.containsKey(word2)) {
            adjacencyList.get(word1).add(word2);
            adjacencyList.get(word2).add(word1);
        }
    }

    /**
     * Método para agregar un conjunto de palabras al grafo.
     *
     * @param words Conjunto de palabras a agregar.
     */
    public void addWords(Set<String> words) {
        for (String word : words) {
            addVertex(word);
            for (String otherWord : words) {
                if (!otherWord.equals(word) && areSimilar(word, otherWord)) {
                    addEdge(word, otherWord);
                }
            }
        }
    }

    /**
     * Método para verificar si dos palabras son similares.
     *
     * @param word1 Primera palabra a comparar.
     * @param word2 Segunda palabra a comparar.
     * @return Verdadero si las palabras son similares, falso en caso contrario.
     */
    private boolean areSimilar(String word1, String word2) {
        int commonLetters = 0;
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) != -1) {
                commonLetters++;
            }
        }
        return commonLetters >= 2; // Cambia este valor para ajustar la cantidad de letras en común necesarias
    }

    /**
     * Método para obtener la matriz de adyacencia del grafo.
     *
     * @return Matriz de adyacencia del grafo.
     */
    public int[][] getAdjacencyMatrix() {
        int size = adjacencyList.size();
        int[][] matrix = new int[size][size];
        String[] vertices = adjacencyList.keySet().toArray(new String[0]);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = adjacencyList.get(vertices[i]).contains(vertices[j]) ? 1 : 0;
            }
        }

        return matrix;
    }

    /**
     * Método para imprimir la matriz de adyacencia del grafo.
     *
     * @return Cadena que representa la matriz de adyacencia del grafo.
     */
    public String printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        StringBuilder sb = new StringBuilder("Matriz de adyacencia:\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}