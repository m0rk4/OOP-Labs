package by.bsuir.mark.oop.task.first.drawing.impl;

import by.bsuir.mark.oop.task.first.drawing.FiguresDrawer;
import by.bsuir.mark.oop.task.first.entity.GeometricFigure;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class FiguresDrawerImpl implements FiguresDrawer {
    @Override
    public void drawFigures(List<GeometricFigure> figures, GraphicsContext graphicsContext) {
        for (GeometricFigure figure : figures) {
            figure.draw(graphicsContext);
        }
    }
}
