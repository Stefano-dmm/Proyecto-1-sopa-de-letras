/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import java.io.FileNotFoundException;
import java.util.HashSet;
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

    public void findAndPrintWords() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, "");
            }
        }
        if (result.isEmpty()) {
            System.out.println("No se encontraron palabras");
        } else {
            System.out.println("Palabras encontradas: " + result);
            grafo.addWords(result);
            String adjacencyMatrix = grafo.printAdjacencyMatrix();
            System.out.println(adjacencyMatrix);
        }
        window.setVisible(true);
    }

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
            window.addVertex(str);
            System.out.println(str + " es una palabra");
            addEdges(str);
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

    private boolean isPrefix(String str) {
        for (String word : dictionary) {
            if (word.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private void addEdges(String word) {
    for (String otherWord : result) {
        if (!otherWord.equals(word) && shareCommonLetters(word, otherWord)) {
            window.addEdge(word, otherWord);
        }
    }
}

private boolean shareCommonLetters(String word1, String word2) {
    Set<Character> set1 = new HashSet<>();
    for (char c : word1.toCharArray()) {
        set1.add(c);
    }

    for (char c : word2.toCharArray()) {
        if (set1.contains(c)) {
            return true;
        }
    }

    return false;
}
}