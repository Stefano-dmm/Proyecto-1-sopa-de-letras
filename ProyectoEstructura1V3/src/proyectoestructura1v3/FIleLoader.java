package proyectoestructura1v3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFileChooser;
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
                String word = s.next();
                // Remove special characters
                String cleanWord = word.replaceAll("[/|\\\\$]", "").toUpperCase();
                dictionary.add(cleanWord); // Convierte todas las palabras a mayúsculas
            }
            s.close();
        } else {
            throw new FileNotFoundException("No file selected");
        }
    }
}