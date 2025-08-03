package org.javafx.mp3player;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MP3PlayerController {

    @FXML
    private Label currentSongLabel;

    private MediaPlayer mediaPlayer;

    private Stage stage;

    // This is set via FXMLLoader's controller injection
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void chooseSong() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose MP3 File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP3 Files", "*.mp3"));

        File selectedFile = fileChooser.showOpenDialog(currentSongLabel.getScene().getWindow());
        if (selectedFile != null) {
            try {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                Media media = new Media(selectedFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                currentSongLabel.setText("Playing: " + selectedFile.getName());

                mediaPlayer.play();  // <--- Make sure you start playback here!

            } catch (Exception e) {
                showError("Could not play the file. Try another one.");
            }
        }
    }


    @FXML
    public void play() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    public void pause() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
