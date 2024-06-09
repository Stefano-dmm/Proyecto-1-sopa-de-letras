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
    private char[][] board;
    private String targetWord;
    private GraphWindow window;
    private List<String> visitedOrder = new ArrayList<>();
    private Grafo grafo = new Grafo();

    /**
     * Constructor para la clase BFS.
     *
     * @param board Tablero de caracteres donde se realizará la búsqueda.
     * @param targetWord Palabra objetivo que se busca en el tablero.
     */
    public BFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase();
        this.window = new GraphWindow();
    }

    /**
     * Método para buscar la palabra objetivo en el tablero.
     *
     * @return Verdadero si la palabra objetivo se encuentra en el tablero, falso en caso contrario.
     */
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

                        // Agregar la letra actual a visitedOrder
                        visitedOrder.add(String.valueOf(board[current.row][current.col]));

                        if (current.str.equals(targetWord)) {
                            window.showGraph("Path: " + current.path);
                            System.out.println("Palabras encontradas: " + visitedOrder);
                            grafo.addWords(new HashSet<>(visitedOrder));
                            String adjacencyMatrix = grafo.printAdjacencyMatrix();
                            window.showGraph(adjacencyMatrix);
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

    /**
     * Método para obtener el orden de los caracteres visitados durante la búsqueda.
     *
     * @return Lista de caracteres visitados.
     */
    public List<String> getVisitedOrder() {
        return visitedOrder;
    }

    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    /**
     * Clase interna para representar un par de coordenadas en el tablero y la cadena formada hasta ahora.
     */
    private static class Pair {
        int row;
        int col;
        String str;
        String path;

        /**
         * Constructor para la clase Pair.
         *
         * @param row Fila en el tablero.
         * @param col Columna en el tablero.
         * @param str Cadena formada hasta ahora.
         * @param path Camino seguido hasta ahora.
         */
        Pair(int row, int col, String str, String path) {
            this.row = row;
            this.col = col;
            this.str = str;
            this.path = path;
        }
    }
}