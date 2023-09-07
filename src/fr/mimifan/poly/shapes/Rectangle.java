package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.utils.ColorUtils;

import java.awt.*;

public class Rectangle extends Shape {

    private int width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        paintComponent(DrawCanvas.getInstance().getFrame().getGraphics());
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getColor());
        g.drawRect(getAnchor().getX(), getAnchor().getY(), width, height);
    }

    @Override
    public String getTypeName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return super.toString() + getTypeName() + " Width: " + width + " Height: " + height;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
