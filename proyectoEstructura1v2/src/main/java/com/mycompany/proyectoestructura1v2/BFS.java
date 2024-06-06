/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura1v2;
import java.util.*;

/**
 *
 * @author mainp
 */

 //falta guardado de orden para visitar letras para imprimirlo

public class BFS {
    private char[][] board;
    private String targetWord;

    public BFS(char[][] board, String targetWord) {
        this.board = board;
        this.targetWord = targetWord.toUpperCase(); // Convert the target word to uppercase
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

                        if (current.str.equals(targetWord)) {
                            System.out.println("Path: " + current.path); // Print the path if the target word is found
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