/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura1v2;

import java.util.Arrays;

/**
 *
 * @author mainp
 * 
 */
public class matriz {

    private static char[][] matrix = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
    }; // Matriz bidimensional de caracteres

    //activa con boton cada vez que inicie alguna busqueda
    //public static void main(String[] args) {
        // Ejemplo: Obtener y modificar caracteres en la matriz
        //char characterA1 = CharacterMatrix.getCharacterAt(0, 0); // Obtener el caracter en (0, 0)
        //System.out.println("Caracter en (0, 0): " + characterA1);

        //matriz.setCharacterAt(1, 1, 'X'); // Modificar el caracter en (1, 1)
        //matriz.setCharacterAt(1, 2, 'X');
        //matriz.setCharacterAt(1, 3, 'X');
        //matriz.setCharacterAt(1, 4, 'X');
        //matriz.setCharacterAt(2, 1, 'X');
        //matriz.setCharacterAt(2, 2, 'X');
        //matriz.setCharacterAt(2, 3, 'X');
        //matriz.setCharacterAt(2, 4, 'X');
        //matriz.setCharacterAt(3, 1, 'X');
        //matriz.setCharacterAt(3, 2, 'X');
        //matriz.setCharacterAt(3, 3, 'X');
        //matriz.setCharacterAt(3, 4, 'X');
        //matriz.setCharacterAt(4, 1, 'X');
        //matriz.setCharacterAt(4, 2, 'X');
        //matriz.setCharacterAt(4, 3, 'X');
        //matriz.setCharacterAt(4, 4, 'X');
        //matriz.printMatrix(); // Imprimir la matriz modificada
    //}
//}

    
    /**
     * 
     * @param row
     * @param col
     * @return 
     */

    // Método para obtener un valor en la matriz
    public static char getCharacterAt(int row, int col) {
        return matrix[row][col];
    }

    // Método para establecer un valor en la matriz
    public static void setCharacterAt(int row, int col, char value) {
        matrix[row][col] = value;
    }

    // Método para imprimir la matriz en la consola
    public static void printMatrix() {
        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // Método para obtener una copia de la matriz
    public static char[][] getMatrixCopy() {
        char[][] copy = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    } 
}
