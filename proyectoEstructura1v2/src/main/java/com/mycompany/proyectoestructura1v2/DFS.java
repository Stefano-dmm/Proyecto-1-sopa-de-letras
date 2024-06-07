/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura1v2;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author mainp
 */

//falta que cree la fuerza de semejansa entre palabras encontradas (verificar esto)

public class DFS {
    private char[][] board;
    private boolean[][] visited;
    private Set<String> result = new LinkedHashSet<>();
    private Set<String> dictionary;
    private GraphWindow window;

    public DFS(char[][] board) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.window = new GraphWindow(); // Create a new GraphWindow

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
            window.showGraph("No se encontraron palabras");
        } else {
            window.showGraph("Palabras encontradas: " + result);
        }
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
            window.showGraph(str + " es una palabra"); // Show the word in the GraphWindow
        }

        visited[i][j] = true;
        dfs(i - 1, j, str); // Arriba
        dfs(i + 1, j, str); // Abajo
        dfs(i, j - 1, str); // Izquierda
        dfs(i, j + 1, str); // Derecha
        dfs(i - 1, j - 1, str); // Diagonal superior izquierda
        dfs(i - 1, j + 1, str); // Diagonal superior derecha
        dfs(i + 1, j - 1, str); // Diagonal inferior izquierda
        dfs(i + 1, j + 1, str); // Diagonal inferior derecha
        visited[i][j] = false; // Desmarca la celda como visitada
    }

    private boolean isPrefix(String str) {
        for (String word : dictionary) {
            if (word.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}