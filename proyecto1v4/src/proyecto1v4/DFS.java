/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author mainp
 */
/**
 * Clase DFS para realizar una búsqueda en profundidad en un tablero de caracteres.
 */
public class DFS {
    private char[][] board;
    private boolean[][] visited;
    private Set<String> result = new LinkedHashSet<>();
    private Set<String> dictionary;
    private GraphWindow window;
    private Grafo grafo = new Grafo();

    /**
     * Constructor para la clase DFS.
     *
     * @param board Tablero de caracteres donde se realizará la búsqueda.
     */
    public DFS(char[][] board) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.window = new GraphWindow();

        try {
            FileLoader fileLoader = new FileLoader();
            this.dictionary = new LinkedHashSet<>();
            for (String word : fileLoader.dictionary) {
                this.dictionary.add(word.toUpperCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }
    }

    /**
     * Método para buscar y imprimir las palabras encontradas en el tablero.
     */
    public void findAndPrintWords() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, "");
            }
        }
        if (result.isEmpty()) {
            window.showGraph("No se encontraron palabras");
            System.out.println("No se encontraron palabras");
        } else {
            window.showGraph("Palabras encontradas: " + result);
            System.out.println("Palabras encontradas: " + result);
            grafo.addWords(result);
            String adjacencyMatrix = grafo.printAdjacencyMatrix();
            window.showGraph(adjacencyMatrix);
        }
    }

    /**
     * Método para realizar la búsqueda en profundidad.
     *
     * @param i Fila en el tablero.
     * @param j Columna en el tablero.
     * @param str Cadena formada hasta ahora.
     */
    private void dfs(int i, int j, String str) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        str += board[i][j];

        if (!isPrefix(str)) {
            return;
        }

        if (dictionary.contains(str)) {
            result.add(str);
            window.showGraph(str + " es una palabra");
            System.out.println(str + " es una palabra");
        }

        visited[i][j] = true;
        dfs(i - 1, j, str);
        dfs(i + 1, j, str);
        dfs(i, j - 1, str);
        dfs(i, j + 1, str);
        dfs(i - 1, j - 1, str);
        dfs(i - 1, j + 1, str);
        dfs(i + 1, j - 1, str);
        dfs(i + 1, j + 1, str);
        visited[i][j] = false;
    }

    /**
     * Método para verificar si una cadena es prefijo de alguna palabra en el diccionario.
     *
     * @param str Cadena a verificar.
     * @return Verdadero si la cadena es prefijo, falso en caso contrario.
     */
    private boolean isPrefix(String str) {
        for (String word : dictionary) {
            if (word.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}