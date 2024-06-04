/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.funcionletrasv2;

import java.util.HashSet;
import java.util.Set;


public class FuncionLetrasV2 {


    private static char[][] wordSearchMatrix = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    };
   
        /**
     * Función recursiva para generar combinaciones de palabras válidas a partir de una matriz de caracteres. Esta función explora
     * la matriz en todas las direcciones posibles (horizontal, vertical, diagonal) y construye palabras válidas siguiendo las restricciones mencionadas anteriormente.
     *
     * @param matrix La matriz de caracteres del tablero de búsqueda de palabras.
     * @param row La fila actual en la que se explora la matriz.
     * @param currentWord La palabra actual que se está construyendo.
     * @param usedLetters Un conjunto para almacenar las letras ya utilizadas en la palabra actual.
     * @param wordLength La longitud deseada de la palabra.
     * **/
    

    // Function to generate word combinations
    private static void generateCombinations(char[][] matrix, int row, String currentWord, Set<Character> usedLetters, int wordLength) {
        if (row == matrix.length || currentWord.length() == wordLength) {
            if (currentWord.length() >= 3 && /* isWordValid(currentWord) */ true) {
                System.out.println(currentWord); // Print the valid word
            }
            return;
        }

        for (int col = 0; col < matrix[row].length; col++) {
            char currentChar = matrix[row][col];
            if (!usedLetters.contains(currentChar)) {
                usedLetters.add(currentChar);
                currentWord += currentChar;

                // Check all possible directions (horizontal, vertical, diagonal)
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];

                    if (isValidCell(matrix, nextRow, nextCol)) {
                        generateCombinations(matrix, nextRow, currentWord, usedLetters, wordLength);
                    }
                }

                currentWord = currentWord.substring(0, currentWord.length() - 1);
                usedLetters.remove(currentChar);
            }
        }
    }

    // Function to check if a cell is valid within the matrix
    private static boolean isValidCell(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    // Define directions for checking adjacent cells
    private static final int[][] DIRECTIONS = {
        {0, 1}, // Right
        {0, -1}, // Left
        {1, 0}, // Down
        {-1, 0}, // Up
        {1, 1}, // Diagonal down-right
        {-1, -1}, // Diagonal up-left
        {1, -1}, // Diagonal up-right
        {-1, 1}  // Diagonal down-left
    };

    public static void main(String[] args) {
        // Print the word search matrix
        for (char[] row : wordSearchMatrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        /**
     * Función para verificar si una celda es válida dentro de la matriz. Una celda es válida si está dentro de los límites de la matriz.
     *
     * @param matrix La matriz de caracteres del tablero de búsqueda de palabras.
     * @param row La fila de la celda a verificar.
     * @param col La columna de la celda a verificar.
     * @return `true` si la celda es válida, `false` en caso contrario.
     */
        
        
        // Generate and print word combinations for each length
        for (int length = 3; length <= wordSearchMatrix.length * wordSearchMatrix[0].length; length++) {
            System.out.println("\nWords of length " + length + ":");
            generateCombinations(wordSearchMatrix, 0, "", new HashSet<>(), length);
        }
    }
}
