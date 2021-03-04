package by.bsuir.mark.task.second;

import by.bsuir.mark.task.second.entity.Triangle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String FXML_NAME = "primary.fxml";
    private static final String APP_NAME = "OOP - 2 / Paint";

    @Override
    public void start(Stage stage) throws IOException {
        URL resource = App.class.getResource(FXML_NAME);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1280, 720);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(APP_NAME);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}