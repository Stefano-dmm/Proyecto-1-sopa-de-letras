/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoestructura1v2;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author mainp
 */

public class FileLoader {
    public Set<String> dictionary = new HashSet<>();

    public FileLoader() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Scanner s = new Scanner(selectedFile);
            while (s.hasNext()){
                dictionary.add(s.next().toUpperCase()); // Convierte todas las palabras a mayúsculas
            }
            s.close();
        } else {
            throw new FileNotFoundException("No file selected");
        }
    }
}