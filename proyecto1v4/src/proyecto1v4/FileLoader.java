package proyecto1v4;

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

/**
 * Clase FileLoader para cargar un archivo de texto que contiene un diccionario de palabras.
 */

public class FileLoader {
    public Set<String> dictionary = new HashSet<>();

    /**
     * Constructor para la clase FileLoader.
     *
     * @throws FileNotFoundException Si no se selecciona ningún archivo.
     */
    public FileLoader() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Scanner s = new Scanner(selectedFile);
            while (s.hasNext()){
                String word = s.next();
                // Elimina caracteres especiales
                String cleanWord = word.replaceAll("[/|\\\\$]", "").toUpperCase();
                dictionary.add(cleanWord); // Convierte todas las palabras a mayúsculas
            }
            s.close();
        } else {
            throw new FileNotFoundException("No se seleccionó ningún archivo");
        }
    }
}