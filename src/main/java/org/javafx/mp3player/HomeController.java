package org.javafx.mp3player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    public void openMusic(ActionEvent event) {
        switchScene("/org/javafx/mp3player/mp3player.fxml", event);
    }

    @FXML
    public void openImageViewer(ActionEvent event) {
        switchScene("/org/javafx/mp3player/imageviewer.fxml", event);
    }

    private void switchScene(String fxmlPath, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // ✅ Get stage from button (event source), not from root
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}