/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.funcionessopadeletras;
import java.util.ArrayList;
import java.util.Arrays;

public class Funcionessopadeletras {
    public static void main(String[] args) {
        String input = "abajofghijklmnop"; // reemplaza con tu cadena de entrada de 16 caracteres
        int[] lengths = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}; // todas las longitudes posibles
        ArrayList<String> generatedWords = new ArrayList<>(); // lista para guardar las palabras generadas

        // Itera sobre todas las longitudes posibles
        for (int length : lengths) {
            char[] combination = new char[length];
            generateCombinations(input, combination, 0, 0, length, generatedWords);
        }

        // Imprime las palabras generadas
        System.out.println("Palabras generadas:");
        for (String word : generatedWords) {
            System.out.println(word);
        }

        // Lee el diccionario desde el arreglo
        ArrayList<String> dictionaryWords = new ArrayList<>(Arrays.asList(
            "abajo", "casa", "perro", "gato", "leon", "tigre", "elefante", "mono", "pajaro", "pez", "flor", "arbol", "coche", "bici"));
            // Agrega aquí las palabras de tu diccionario
        

        // Compara las palabras generadas con las del diccionario
        ArrayList<String> matchingWords = new ArrayList<>();
        for (String word : generatedWords) {
            if (dictionaryWords.contains(word)) {
                matchingWords.add(word);
            }
        }

        // Imprime las palabras que coincidieron
        if (matchingWords.size() > 0) {
            System.out.println("Palabras que coincidieron con el diccionario:");
            for (String word : matchingWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No hay palabras que coincidan con el diccionario.");
        }
    }

    private static void generateCombinations(String input, char[] combination, int inputIndex, int combinationIndex, int maxLength, ArrayList<String> generatedWords) {
        // Caso base: si la combinación está completa, agrega la palabra a la lista y regresa
        if (combinationIndex == maxLength) {
            generatedWords.add(new String(combination));
            return;
        }

        // Caso base: si hemos llegado al final de la cadena de entrada, regresa
        if (inputIndex == input.length()) {
            return;
        }

        // Caso recursivo: agrega el carácter actual a la combinación y recursa
        combination[combinationIndex] = input.charAt(inputIndex);
        generateCombinations(input, combination, inputIndex + 1, combinationIndex + 1, maxLength, generatedWords);

        // Caso recursivo: salta el carácter actual y recursa
        generateCombinations(input, combination, inputIndex + 1, combinationIndex, maxLength, generatedWords);
    }
}