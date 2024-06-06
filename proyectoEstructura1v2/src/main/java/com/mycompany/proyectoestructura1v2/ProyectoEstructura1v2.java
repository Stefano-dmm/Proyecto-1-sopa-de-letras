/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoestructura1v2;

import javax.swing.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author mainp
 */

public class ProyectoEstructura1v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
            {'H', 'B', 'C', 'D'},
            {'E', 'O', 'G', 'H'},
            {'I', 'J', 'L', 'L'},
            {'M', 'A', 'O', 'P'}
        };

        // Ejemplo: Obtener y modificar caracteres en la matriz 
        // char characterA1 = CharacterMatrix.getCharacterAt(0, 0); 
        // Obtener el caracter en (0, 0) 
        // System.out.println("Caracter en (0, 0): " + characterA1); 
        // matriz.setCharacterAt(1, 1, 'X'); // Modificar el caracter en (1, 1) 
        // matriz.setCharacterAt(1, 2, 'X'); 
        // matriz.setCharacterAt(1, 3, 'X'); 
        // matriz.setCharacterAt(1, 4, 'X'); 
        // matriz.setCharacterAt(2, 1, 'X'); 
        // matriz.setCharacterAt(2, 2, 'X'); 
        // matriz.setCharacterAt(2, 3, 'X'); 
        // matriz.setCharacterAt(2, 4, 'X'); 
        // matriz.setCharacterAt(3, 1, 'X'); 
        // matriz.setCharacterAt(3, 2, 'X'); 
        // matriz.setCharacterAt(3, 3, 'X'); 
        // matriz.setCharacterAt(3, 4, 'X'); 
        // matriz.setCharacterAt(4, 1, 'X'); 
        // matriz.setCharacterAt(4, 2, 'X'); 
        // matriz.setCharacterAt(4, 3, 'X'); 
        // matriz.setCharacterAt(4, 4, 'X'); 
        // matriz.printMatrix(); // Imprimir la matriz modificada //}

        System.out.println("Elija el método de búsqueda: 1 para DFS, 2 para BFS");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        if (choice == 1) {
            DFS dfs = new DFS(board);
            dfs.findAndPrintWords();
        } else if (choice == 2) {
            System.out.println("Ingrese la palabra objetivo");
            String targetWord = scanner.nextLine().toUpperCase();
            BFS bfs = new BFS(board, targetWord);
            boolean found = bfs.findWord();
            System.out.println(found ? "La palabra fue encontrada" : "La palabra no fue encontrada");
        } else {
            System.out.println("Opción no válida");
        }

        scanner.close();
    }
}