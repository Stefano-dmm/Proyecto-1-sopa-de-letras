import java.util.Arrays;

/**
 * Genera todas las combinaciones posibles de una cadena de entrada dada.
 */
public class Combinations {
    /**
     * Método principal para probar la generación de combinaciones.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        String input = "abcdefghijklmnop"; // reemplaza con tu cadena de entrada de 16 caracteres
        int[] lengths = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}; // todas las longitudes posibles

        // Itera sobre todas las longitudes posibles
        for (int length : lengths) {
            char[] combination = new char[length];
            generateCombinations(input, combination, 0, 0, length);
        }
    }

    /**
     * Método recursivo para generar todas las combinaciones posibles de la cadena de entrada.
     * 
     * @param input la cadena de entrada
     * @param combination la combinación actual que se está construyendo
     * @param inputIndex el índice actual en la cadena de entrada
     * @param combinationIndex el índice actual en la matriz de combinación
     * @param maxLength la longitud máxima de la combinación
     */
    private static void generateCombinations(String input, char[] combination, int inputIndex, int combinationIndex, int maxLength) {
        // Caso base: si la combinación está completa, imprímela
        if (combinationIndex == maxLength) {
            System.out.println(new String(combination));
            return;
        }

        // Caso base: si hemos llegado al final de la cadena de entrada, regresa
        if (inputIndex == input.length()) {
            return;
        }

        // Caso recursivo: agrega el carácter actual a la combinación y recursa
        combination[combinationIndex] = input.charAt(inputIndex);
        generateCombinations(input, combination, inputIndex + 1, combinationIndex + 1, maxLength);

        // Caso recursivo: salta el carácter actual y recursa
        generateCombinations(input, combination, inputIndex + 1, combinationIndex, maxLength);
    }
}