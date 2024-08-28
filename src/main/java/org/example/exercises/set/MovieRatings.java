package org.example.exercises.set;

/*
    Movie Ratings:
    Implement a movie rating system using both a HashSet and a TreeSet
    where movies are stored and sorted based on their ratings.
 */

import java.time.LocalDate;
import java.util.*;

// Comparable seteaza o regula UNIVERSALA de sortare
// In cazul in care Folosim Collections.sort sau list.sort() putem opta
// pentru utilizarea regulii setate in clasa de obiect,
// sau o putem suprascrie cu un Comparator specific

// Comparable si Comparator sunt ambele interfete utilizate in contextul sortarii
// Comparable e utilizat la nivelul claselor de obiect
// Comparator e utilizat la nivelul algoritmilor de sortare tipici structurilor de date
class Movie implements Comparable<Movie> {

    private String title;
    private Double rating;
    private LocalDate releaseDate;

    public Movie(Double rating, LocalDate releaseDate, String title) {
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public int compareTo(Movie anotherMovie) {
        return this.getTitle().compareTo(anotherMovie.getTitle());  // comaparam this -> CURRENT MOVIE cu ANOTHER RANDOM MOVIE
    }
}

public class MovieRatings {

    public static void main(String[] args) {
        Set<Movie> movieUnorderedSet = new HashSet<>();

        movieUnorderedSet.add(new Movie(8.8, LocalDate.of(2004, 12, 4), "Inception"));
        movieUnorderedSet.add(new Movie(5.2, LocalDate.of(2006, 12, 5), "The Dark Knight"));
        movieUnorderedSet.add(new Movie(9.1, LocalDate.of(2004, 6, 4), "Pulp Fiction"));
        movieUnorderedSet.add(new Movie(8.8, LocalDate.of(2004, 6, 2), "Interstellar"));

        System.out.println("Setul contine:\n" + movieUnorderedSet);
        System.out.println();

        // ArrayList si sort
        List<Movie> movieSortedList = new ArrayList<>(movieUnorderedSet);
        System.out.println("Lista neordonata contine:");
        displayList(movieSortedList);

        /*
         * Comparator are structura de Builder class.
         *
         * Ce este un Builder?
         *   Este o clasa de obiect unde semnatura metodelor cu tip de returnare contine clasa curenta.
         *   Astfel incat sa putem avea chained invocations (apelari inlantuite)
         *
         * Comparator
         *   .comparing(...)
         *   .thenCompare(...)
         *   .etc;
         * */
        movieSortedList.sort(Comparator
                .comparing(Movie::getRating)
                .thenComparing(Movie::getReleaseDate)
                .reversed()
        );
        System.out.println("Lista sortata contine:");
        displayList(movieSortedList);

        /*
         * Comparator.comparing(Movie::getRating)
         * - se uita intern in clasa Movie
         * - si compara 2 elemente random din lista noastra pe baza metodei de referinta
         * - metoda de referinta este de regula un getter (fiind datele noastre sunt private)
         *
         * - referentierea directa prin numele claseii::metoda (Movie::getRating) functioneaza doar
         * pentru metodele NEPARAMETRIZATE
         *
         * */

        // Collections si sort
        List<Movie> movieSortedList2 = new ArrayList<>(movieUnorderedSet);
        Collections.sort(
                movieSortedList2,
                Comparator
                        .comparing(Movie::getReleaseDate)
                        .reversed()
        );
        System.out.println("Lista sortata contine:");
        displayList(movieSortedList2);

        // TreeSet
        // Set este interfata parinte pentru SortedSet
        // SortedSet adauga functionalitatile de sortare prin comparator
        // SortedSet este implementata de TreeSet
        SortedSet<Movie> movieOrderedSet = new TreeSet<>();

        movieOrderedSet.add(new Movie(8.8, LocalDate.of(2004, 12, 4), "Inception"));
        movieOrderedSet.add(new Movie(5.2, LocalDate.of(2006, 12, 5), "The Dark Knight"));
        movieOrderedSet.add(new Movie(9.1, LocalDate.of(2004, 6, 4), "Pulp Fiction"));
        movieOrderedSet.add(new Movie(8.8, LocalDate.of(2004, 6, 2), "Interstellar"));

        System.out.println("Setul sortat contine:");
        displayList(movieOrderedSet);

        // Inception ? Interstellar (se compara fiecare cod ascii al caracterelor cu acelasi index)
    }

    public static void displayList(Collection<Movie> list) {

        for (Movie it : list) {
            System.out.println(it.getTitle() + " " + it.getRating() + " " + it.getReleaseDate());
        }
        System.out.println();
    }
}