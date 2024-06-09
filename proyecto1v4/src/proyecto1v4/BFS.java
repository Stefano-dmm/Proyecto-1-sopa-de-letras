package proyecto1v4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;

/**
 *
 * @author mainp
 */

 //falta guardado de orden para visitar letras para imprimirlo para que se vea como grafo

/**
 * Clase BFS para realizar una búsqueda en anchura en un tablero de caracteres.
 */
public class BFS {
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    private char[][] board;
    private String targetWord;
    private List<String> visitedOrder = new ArrayList<>();
    private Grafo grafo = new Grafo();
    private GraphWindow window;

    public BFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase();
        this.window = new GraphWindow();
    }

    public boolean findWord() {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == targetWord.charAt(0)) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j, String.valueOf(board[i][j]), "(" + i + "," + j + "):" + board[i][j]));
                    while (!queue.isEmpty()) {
                        Pair current = queue.poll();
                        String currentLetter = String.valueOf(board[current.row][current.col]);
                        visitedOrder.add(currentLetter);
                        window.addVertex(currentLetter); // Add the visited letter as a vertex in the graph
                        if (current.str.equals(targetWord)) {
                            System.out.println("Palabras encontradas: " + visitedOrder);
                            grafo.addWords(new HashSet<>(visitedOrder));
                            String adjacencyMatrix = grafo.printAdjacencyMatrix();
                            System.out.println(adjacencyMatrix);
                            printGraphOrder();
                            return true;
                        }
                        for (int[] direction : DIRECTIONS) {
                            int newRow = current.row + direction[0];
                            int newCol = current.col + direction[1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                                String newStr = current.str + board[newRow][newCol];
                                if (targetWord.startsWith(newStr)) {
                                    String newPath = current.path + " -> (" + newRow + "," + newCol + "):" + board[newRow][newCol];
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

    public List<String> getVisitedOrder() {
        return visitedOrder;
    }

    public void printGraphOrder() {
        if (window != null) {
            List<String> order = getVisitedOrder();
            for (int i = 0; i < order.size() - 1; i++) {
                String currentLetter = order.get(i);
                String nextLetter = order.get(i + 1);
                window.addEdge(currentLetter, nextLetter);
                grafo.addEdge(currentLetter, nextLetter); // Add a link with weight 1 between the current letter and the next letter
            }
            window.repaint();
        }
    }

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