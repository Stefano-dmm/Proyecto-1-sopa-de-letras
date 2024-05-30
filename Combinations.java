import java.util.Arrays;

public class Combinations {
    public static void main(String[] args) {
        String input = "abcdefghijklmnop"; // replace with your 16-character input
        int[] lengths = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}; // all possible lengths

        for (int length : lengths) {
            char[] combination = new char[length];
            generateCombinations(input, combination, 0, 0, length);
        }
    }

    private static void generateCombinations(String input, char[] combination, int inputIndex, int combinationIndex, int maxLength) {
        if (combinationIndex == maxLength) {
            System.out.println(new String(combination));
            return;
        }

        if (inputIndex == input.length()) {
            return;
        }

        combination[combinationIndex] = input.charAt(inputIndex);
        generateCombinations(input, combination, inputIndex + 1, combinationIndex + 1, maxLength);
        generateCombinations(input, combination, inputIndex + 1, combinationIndex, maxLength);
    }
}