package fr.mimifan.poly.frames;

import fr.mimifan.poly.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingZone extends JPanel {

    private static DrawingZone instance = null;
    private Color currentColor = Color.BLACK;
    private Shape currentSelectedShape = null;

    private List<Shape> shapes = new ArrayList<>();

    public DrawingZone() {
        instance = this;
        setSize(DrawingWindow.WIDTH, DrawingWindow.HEIGHT);
        setBounds(0, 0, getWidth(), getHeight());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        paint(getGraphics());
    }

    public static DrawingZone getInstance() {
        return instance;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void setCurrentSelectedShape(Shape s) {
        currentSelectedShape = s;
    }

    public Shape getCurrentSelectedShape() {
        return currentSelectedShape;
    }

}
