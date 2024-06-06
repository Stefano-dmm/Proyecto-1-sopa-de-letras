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
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        FileLoader fileLoader = null;
        try {
            fileLoader = new FileLoader();
        } catch (FileNotFoundException e) {
            System.out.println("No se seleccionó ningún archivo");
            return;
        }
        DFS dfs = new DFS(board, fileLoader.dictionary);
        dfs.findAndPrintWords();
    }
}