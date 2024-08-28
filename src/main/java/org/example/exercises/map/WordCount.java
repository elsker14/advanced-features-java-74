package org.example.exercises.map;

/*
    Word Frequency Counter:
    Write a program that takes a sentence as input and counts the frequency of each word using a HashMap.

    Input:
        Ana are mere si pere si mai are de cumparat visine

    Map <K, V> => K - cuvantul (String), V - numarul de aparitii ale cuvantului

    Output:
        Ana 1
        are 2
        mere 1
        si 2
        pere 1
        ...
 */

import java.util.*;

public class WordCount {

    public static void main(String[] args) {

        /* Citirea propozitiei de la tastatura folosind Scanner */
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        System.out.println(sentence);

        /* Apelam metoda countWordFrequency() pentru a calcula frecventa aparitiei cuvintelor */
        Map<String, Integer> wordFrequency = countWordFrequency(sentence);
            // = new HashMap<>() - aici facem instantierea cu o mapa goala, similar unui constructor neparametrizat
            // = countWordFrequency() - aici facem instantierea cu o mapa cu valori, similar unui constructor parametrizat

        /* Afisare a mapei (poate fi o metoda - display()) */
        displayMap(wordFrequency);

        /* todo: Adaptam algoritmul folosind TreeMap astfel incat sa sortam elementele atat dupa cheie, cat si pentru valoare */
        /* todo: Adaptam algoritmul pentru verificarea aparitiilor literelor alfabetului intr-o propozitie */
    }

    private static void displayMap(Map<String, Integer> myMap) {
        // Convertim mapa la un Set de perechi -> Set<Map.Entry<String,Integer>>
        // Map.Entry<String,Integer> este un tip de date pentru reprezentarea perechilor individuale dintr-o mapa.
        // metoda .entrySet() converteste mapa la un set de perechi
        for(Map.Entry<String, Integer> pair: myMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static Map<String, Integer> countWordFrequency(String text) {

        /* Definim variabila/obiectul/structura de date pe care o returnam */
        Map<String, Integer> result = new HashMap<>();

        /* Prelucrarea */
        String[] splittedText = text.split("\\s+");
        /*
            \\ = escape sequence pattern
            s = orice caracter de tipul WHITESPACE (caractere invizibile: space, tab, new line..)
            + = unu sau mai multe aparitii ale TOKENULUI anterior
            [] = colectam mai multi tokeni pentru a implementa diverse reguli generice
         */
        for(String word: splittedText) {
            if(result.containsKey(word)){
                // cheia exista in mapa deja, pentru ca containsKey a intors true
                result.put(word, result.get(word) + 1);
            } else {
                // cheia nu exista in mapa, pentru ca containsKey a intors false
                result.put(word, 1);
            }
        }

        /* Returnarea rezultatului */
        return result;
    }

    private List<Object> getMyList() {
        List<Object> result = new ArrayList<>();

        return result;
    }

    private Set<Object> getMySet() {
        Set<Object> result = new TreeSet<>();

        return result;
    }

    /* countWordFrequency() - split */

    /* display() */
}
