package by.bsuir.m0rk4.oop.task.third;

import by.bsuir.m0rk4.oop.task.third.controller.PrimaryController;
import by.bsuir.m0rk4.oop.task.third.data.deserialization.factory.VehicleDeserializerFactory;
import by.bsuir.m0rk4.oop.task.third.data.serialization.factory.VehicleSerializerFactory;
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

    private static final String FXML_VIEW_NAME = "primary.fxml";
    private static final String APP_TITLE = "OOP - 3 / Hierarchy & (De-)Serialization";

    @Override
    public void start(Stage stage) throws IOException {
        URL resource = App.class.getResource(FXML_VIEW_NAME);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        VehicleSerializerFactory vehicleSerializerFactory = new VehicleSerializerFactory();
        VehicleDeserializerFactory vehicleDeserializerFactory = new VehicleDeserializerFactory();
        fxmlLoader.setControllerFactory(c -> new PrimaryController(
                vehicleSerializerFactory,
                vehicleDeserializerFactory
        ));

        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 640, 480);

        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}