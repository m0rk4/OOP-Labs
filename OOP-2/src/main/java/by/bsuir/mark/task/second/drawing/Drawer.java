package by.bsuir.mark.task.second.drawing;

import by.bsuir.mark.task.second.entity.Figure;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drawer {

    private final GraphicsContext graphicsContext;

    public Drawer(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void draw(Figure figure, Color color) {
        graphicsContext.setStroke(color);
        graphicsContext.setFill(color);
        figure.draw(graphicsContext);
    }
}
