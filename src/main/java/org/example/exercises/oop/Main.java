package org.example.exercises.oop;

/*
    Create a multimedia player system where each multimedia item (audio, video) has its own methods to play and stop.
        - clasa parinte MultimediaItem (instantiaza cele 2 metode generice play/stop)
        - clase copil MultimediaAudio si MultimediaVideo

    Implement abstraction by defining an abstract class MultimediaItem with abstract methods for playing and stopping.
        - clasa parinte va fi abstracta
        - metodele generice din clasa parinte vor fi abstracte

    Create concrete classes Audio and Video that extend the MultimediaItem class and implement their specific methods
    for playing and stopping.
        - cream clasele copil MultimediaAudio si MultimediaVideo
        - suprascriem metodele play/stop din clasa parinte
*/

public class Main {

    public static void main(String[] args) {
        MultimediaAudio multimediaAudio = new MultimediaAudio("Audio Song");
        MultimediaVideo multimediaVideo = new MultimediaVideo("Video Movie");

        multimediaAudio.play();
        multimediaAudio.stop();

        multimediaVideo.play();
        multimediaVideo.stop();
    }
}
