package by.bsuir.mark.oop.task.first;

import by.bsuir.mark.oop.task.first.drawing.FiguresDrawer;
import by.bsuir.mark.oop.task.first.drawing.impl.FiguresDrawerImpl;
import by.bsuir.mark.oop.task.first.entity.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class App extends Application {

    private static final int SCENE_WIDTH = 1280;
    private static final int SCENE_HEIGHT = 720;
    private static final String APP_TITLE = "OOP 1 - Figures Inheritance & Polymorphism";

    private static final List<GeometricFigure> FIGURES = Arrays.asList(
            new PolyLine(new Point2D(10, 10), new Point2D(200, 100), new Point2D(300, 50)),
            new Polygon(new Point2D(250, 100), new Point2D(270, 190),
                    new Point2D(550, 180), new Point2D(350, 100)),
            new Ellipse(new Point2D(500, 200), 200, 100),
            new Circle(new Point2D(680, 290), 130),
            new Triangle(new Point2D(800, 450), new Point2D(900, 500), new Point2D(1050, 450)),
            new Rectangle(new Point2D(950, 520), 250, 50),
            new Square(new Point2D(1150, 590), 100)
    );

    private final FiguresDrawer figuresDrawer = new FiguresDrawerImpl();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        figuresDrawer.drawFigures(FIGURES, graphicsContext);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}