/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1v4;
import java.util.Arrays;

/**
 *
 * @author mainp
 * 
 */
/**
 * Clase matriz que contiene una matriz bidimensional de caracteres y métodos para manipularla.
 */
public class matriz {

    private static char[][] matrix = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'},
        {'A', 'D', 'E', 'E'}
    }; // Matriz bidimensional de caracteres

    /**
     * Método para obtener un valor en la matriz.
     *
     * @param row Índice de la fila.
     * @param col Índice de la columna.
     * @return Carácter en la posición especificada.
     */
    public static char getCharacterAt(int row, int col) {
        return matrix[row][col];
    }

    /**
     * Método para establecer un valor en la matriz.
     *
     * @param row Índice de la fila.
     * @param col Índice de la columna.
     * @param value Valor a establecer.
     */
    public static void setCharacterAt(int row, int col, char value) {
        matrix[row][col] = value;
    }

    /**
     * Método para imprimir la matriz en la consola.
     */
    public static void printMatrix() {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método para obtener una copia de la matriz.
     *
     * @return Copia de la matriz.
     */
    public static char[][] getMatrixCopy() {
        char[][] copy = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    } 
}