package proyecto1v4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;

/**
 *
 * @author mainp
 * 
 * Clase BFS para realizar una búsqueda en anchura en un tablero de caracteres.
 */


public class BFS {
    /**
     * Las direcciones posibles para moverse en el tablero.
     * 
     */
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    
     /**
     * El tablero de caracteres.
     * La palabra objetivo a buscar en el tablero.
     * La lista de adyacencia que representa el gráfico.
     * La lista de vértices en el orden en que se visitaron durante la búsqueda en anchura.
     * Construye un nuevo objeto BFS con el tablero y la palabra objetivo.
     */

    private char[][] board;
    private String targetWord;
    private Map<String, Set<String>> adjacencyList = new HashMap<>();
    private List<String> order = new ArrayList<>();
    
    /**
     * Construye un nuevo objeto BFS con el tablero y la palabra objetivo.
     *
     * @param board el tablero de caracteres
     * @param targetWord la palabra objetivo a buscar
     */

    public BFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase();
    }
    
    /**
     * Realiza la búsqueda en anchura en el tablero para encontrar la palabra objetivo.
     *
     * @return true si la palabra objetivo se encuentra en el tablero, false en caso contrario
     */

    public boolean findWord() {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j, String.valueOf(board[i][j])));
                    while (!queue.isEmpty()) {
                        Pair current = queue.poll();
                        String currentLetter = String.valueOf(board[current.row][current.col]);
                        adjacencyList.putIfAbsent(currentLetter, new HashSet<>());
                        order.add(currentLetter);
                        if (current.str.equals(targetWord)) {
                            GraphWindowsbfs window = new GraphWindowsbfs(order, adjacencyList);
                            window.setVisible(true);
                            return true;
                        }
                        for (int[] direction : DIRECTIONS) {
                            int newRow = current.row + direction[0];
                            int newCol = current.col + direction[1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                                String newStr = current.str + board[newRow][newCol];
                                String newLetter = String.valueOf(board[newRow][newCol]);
                                adjacencyList.get(currentLetter).add(newLetter);
                                adjacencyList.putIfAbsent(newLetter, new HashSet<>());
                                adjacencyList.get(newLetter).add(currentLetter);
                                queue.add(new Pair(newRow, newCol, newStr));
                                visited[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Devuelve la lista de adyacencia que representa el gráfico.
     *
     * @return la lista de adyacencia
     */

    public Map<String, Set<String>> getAdjacencyList() {
        return adjacencyList;
    }
/**
     * Devuelve la lista de vértices en el orden en que se visitaron durante la búsqueda en anchura.
     *
     * @return la lista de vértices visitados
     */
    public List<String> getOrder() {
        return order;
    }
 /**
     * Clase interna para representar un par de coordenadas en el tablero y la cadena formada hasta ahora.
     */
    private static class Pair {
        int row;
        int col;
        String str;
/**
         * Construye un nuevo par con las coordenadas dadas y la cadena.
         *
         * @param row la fila en el tablero
         * @param col la columna en el tablero
         * @param str la cadena formada hasta ahora
         */
        Pair(int row, int col, String str) {
            this.row = row;
            this.col = col;
            this.str = str;
        }
    }
}