package org.javafx.mp3player;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class HomeController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void openMusic() {
        switchScene("/org/javafx/mp3player/mp3player.fxml");
    }

    @FXML
    public void openImageViewer() {
        switchScene("/org/javafx/mp3player/imageviewer.fxml");
    }

    private void switchScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            stage = (Stage) root.getScene().getWindow(); // ensure we get current stage
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
