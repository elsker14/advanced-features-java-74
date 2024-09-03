package org.example.streams;

import java.util.Arrays;
import java.util.List;

/*
    Fie o lista de valori. Calculati suma patratelor numerelor pare din lista.

    1,2,3,4,5 -> 2^2 + 4^2 = 4 + 16 = 20
 */

public class SumOfSquareIntegers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Suma patratelor iterativ: " + calculateSquareSumOfEvenNumbersIteratively(numbers));
        System.out.println("\nSuma patratelor streams: " + calculateSquareSumOfEvenNumbersStreams(numbers));
        System.out.println("\nSuma patratelor streams: " + calculateSquareSumOfEvenNumbersStreams2(numbers));
    }

    private static Integer calculateSquareSumOfEvenNumbersIteratively(List<Integer> numbers) {
        Integer result = 0;

        for (Integer it : numbers) {
            if (it % 2 == 0) {
                result += it * it; // Math.pow(it,2)
            }
        }

        return result;
    }

    private static Integer calculateSquareSumOfEvenNumbersStreams(List<Integer> numbers) {
        // PEEK = preia streamul pana in punctul curent, si executa pentru fiecare element o functie,
        // dar nu modifica structura streamului in niciun fel

        return numbers
                // operatia de conversie
                .stream()
                // operatii intermediare
                .filter(it -> it % 2 == 0)  // cream o sublista doar cu valori pare
                .peek(it -> System.out.print(it + " "))
                .map(it -> it * it) // cream o sublista doar cu valori pare la patrat
                .peek(it -> System.out.print(it + " "))
                // operatia de colectare/reductie
                .reduce(0, Integer::sum);
    }

    private static Integer calculateSquareSumOfEvenNumbersStreams2(List<Integer> numbers) {
       return numbers
                .stream()
                .filter(it -> it % 2 == 0)
                .map(it -> (int)Math.pow(it, 2))
                .reduce(0, Integer::sum);
    }

}
