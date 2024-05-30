import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CombinacionesLetrasInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las letras (sin espacios): ");
        String letras = scanner.nextLine();

        List<String> combinaciones = generarCombinacionesUnicas(letras);

        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    private static List<String> generarCombinacionesUnicas(String letras) {
        List<String> combinaciones = new ArrayList<>();
        HashSet<String> combinacionesUnicas = new HashSet<>(); // To store unique combinations without repetition

        for (int longitudCombinacion = 1; longitudCombinacion <= letras.length(); longitudCombinacion++) {
            generarCombinacionesRecursivasUnicas(letras, "", combinacionesUnicas, 0, longitudCombinacion);
        }

        combinaciones.addAll(combinacionesUnicas);
        return combinaciones;
    }

    private static void generarCombinacionesRecursivasUnicas(String letras, String combinacionActual, HashSet<String> combinacionesUnicas, int indiceActual, int longitudCombinacion) {
        if (combinacionActual.length() == longitudCombinacion) {
            combinacionesUnicas.add(combinacionActual); // Add unique combination to the set
            return;
        }

        for (int i = indiceActual; i < letras.length(); i++) {
            String nuevaCombinacion = combinacionActual + letras.charAt(i);
            generarCombinacionesRecursivasUnicas(letras, nuevaCombinacion, combinacionesUnicas, i + 1, longitudCombinacion);

            // Generate combinations of smaller lengths within the loop
            if (longitudCombinacion > 1) {
                generarCombinacionesRecursivasUnicas(letras, nuevaCombinacion, combinacionesUnicas, i + 1, longitudCombinacion - 1);
            }
        }
    }
}
