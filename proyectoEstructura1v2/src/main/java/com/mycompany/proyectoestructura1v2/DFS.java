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

//falta que cree la fuerza de semejansa entre palabras encontradas (verificar esto)


public class DFS {
    private char[][] board;
    private String targetWord;
    private Map<String, List<String>> adjacencyList;

    public DFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase(); // Convert the target word to uppercase
        this.adjacencyList = new HashMap<>(); // Create a new adjacency list
    }

    public boolean findWord() {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == targetWord.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (dfs(i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int index, boolean[][] visited) {
        if (index == targetWord.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != targetWord.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        String word = targetWord.substring(0, index + 1);
        if (!adjacencyList.containsKey(word)) {
            adjacencyList.put(word, new ArrayList<>());
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                String neighbor = targetWord.substring(0, index + 2);
                if (!adjacencyList.get(word).contains(neighbor)) {
                    adjacencyList.get(word).add(neighbor);
                }

                if (dfs(newRow, newCol, index + 1, visited)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;

        return false;
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }
}