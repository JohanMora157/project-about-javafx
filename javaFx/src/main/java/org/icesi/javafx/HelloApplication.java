package org.icesi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        onWindowOpen("reception-view.fxml",stage);
    }

    public static void onWindowOpen(String fxml, Stage currentStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
            currentStage.setScene(scene);
            currentStage.show();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}