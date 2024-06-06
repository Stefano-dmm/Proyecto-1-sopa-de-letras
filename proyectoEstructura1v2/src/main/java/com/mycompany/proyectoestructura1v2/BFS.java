/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mainp
 */

 //falta guardado de orden para visitar letras para imprimirlo para que se vea como grafo


public class BFS {
    private char[][] board;
    private String targetWord;
    private GraphWindow window;
    private Graph<String, DefaultEdge> graph;

    public BFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase(); // Convert the target word to uppercase
        this.window = new GraphWindow(); // Create a new GraphWindow
        this.graph = new SimpleGraph<>(DefaultEdge.class); // Create a new graph
    }

    public boolean findWord() {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String vertex = "(" + i + "," + j + "):" + board[i][j];
                graph.addVertex(vertex); // Add the vertex to the graph

                if (i > 0) {
                    // Add an edge to the vertex above
                    String aboveVertex = "(" + (i - 1) + "," + j + "):" + board[i - 1][j];
                    graph.addEdge(vertex, aboveVertex);
                }

                if (j > 0) {
                    // Add an edge to the vertex to the left
                    String leftVertex = "(" + i + "," + (j - 1) + "):" + board[i][j - 1];
                    graph.addEdge(vertex, leftVertex);
                }

                if (board[i][j] == targetWord.charAt(0)) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j, String.valueOf(board[i][j]), vertex));

                    while (!queue.isEmpty()) {
                        Pair current = queue.poll();

                        if (current.str.equals(targetWord)) {
                            window.showGraph(graph); // Show the graph in the GraphWindow
                            return true;
                        }

                        for (int[] direction : DIRECTIONS) {
                            int newRow = current.row + direction[0];
                            int newCol = current.col + direction[1];

                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                                String newStr = current.str + board[newRow][newCol];
                                if (targetWord.startsWith(newStr)) {
                                    String newPath = "(" + newRow + "," + newCol + "):" + board[newRow][newCol];
                                    queue.add(new Pair(newRow, newCol, newStr, newPath));
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    private static class Pair {
        int row;
        int col;
        String str;
        String path;

        Pair(int row, int col, String str, String path) {
            this.row = row;
            this.col = col;
            this.str = str;
            this.path = path;
        }
    }
}