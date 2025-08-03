module org.javafx.mp3player {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.javafx.mp3player to javafx.fxml;
    exports org.javafx.mp3player;
}