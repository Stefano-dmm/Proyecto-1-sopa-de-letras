/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura1v2;

import java.util.*;
import java.io.*;

/**
 *
 * @author mainp
 */

public class DFS {
    private char[][] board;
    private boolean[][] visited;
    private Set<String> result = new HashSet<>();
    private Set<String> dictionary;

    public DFS(char[][] board, Set<String> dictionary) {
        this.board = board;
        this.dictionary = dictionary;
        this.visited = new boolean[board.length][board[0].length];
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
        }

        visited[i][j] = true;
        dfs(i - 1, j, str);
        dfs(i + 1, j, str);
        dfs(i, j - 1, str);
        dfs(i, j + 1, str);
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
}