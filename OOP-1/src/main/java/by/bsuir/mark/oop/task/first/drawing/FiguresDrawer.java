package by.bsuir.mark.oop.task.first.drawing;

import by.bsuir.mark.oop.task.first.entity.GeometricFigure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public interface FiguresDrawer {
    void drawFigures(List<GeometricFigure> figures, GraphicsContext graphicsContext);
}
