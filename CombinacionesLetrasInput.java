import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinacionesLetrasInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las letras (sin espacios): ");
        String letras = scanner.nextLine();

        List<String> combinaciones = generarCombinaciones(letras);

        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    private static List<String> generarCombinaciones(String letras) {
        List<String> combinaciones = new ArrayList<>();

        for (int longitudCombinacion = 1; longitudCombinacion <= letras.length(); longitudCombinacion++) {
            generarCombinacionesRecursivas(letras, "", combinaciones, 0, longitudCombinacion);
        }

        return combinaciones;
    }

    private static void generarCombinacionesRecursivas(String letras, String combinacionActual, List<String> combinaciones, int indiceActual, int longitudCombinacion) {
        if (indiceActual == longitudCombinacion) {
            combinaciones.add(combinacionActual);
            return;
        }

        for (int i = indiceActual; i < letras.length(); i++) {
            String nuevaCombinacion = combinacionActual + letras.charAt(i);
            generarCombinacionesRecursivas(letras, nuevaCombinacion, combinaciones, i + 1, longitudCombinacion);
        }
    }
}
