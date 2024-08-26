package org.example.exercises.oop;

/*
    Clasa parinte (clasa de configuratie):
    - poate fi abstracta, deoarece nu ne intereseaza sa o utilizam pentru a instantia obiecte,
    pentru acest scop vom avea clasele copil care o mostenesc
    - atributele pot fi protected, deoarece ne intereseaza ca ele ca poata fi vizibile in clasele copil,
    fara a utiliza getters/setters
    - constructori (neparametrizat sau parametrizati)
    - getters/setters/toString
    - metodele pot fi abstracte, deoarece daca nu cautam sa instantiam obiecte dupa clasa parinte,
    nu va fi necesar sa stocam metode cu corp de implementare pentru ca nu vor fi apelate niciodata
 */

public abstract class MultimediaItem {

    protected String title;

    public MultimediaItem() {

    }

    public MultimediaItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MultimediaItem{" +
                "title='" + title + '\'' +
                '}';
    }

    // todo: mutati comportamentul clasei intr-o interfata pe care clasele copil sa o implementeze
    public abstract void play();

    public abstract void stop();
}
