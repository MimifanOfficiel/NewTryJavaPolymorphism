package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawingZone;

import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public Circle(int x, int y) {
        super(x, y);
        this.radius = 50;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DrawingZone.getInstance().getCurrentColor());
        g.drawOval(getAnchor().getX(), getAnchor().getY(), radius, radius);
        getAnchor().draw(g, isSelected());
    }

    @Override
    public void edit() {

    }

    @Override
    public String getTypeName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return super.toString() + getTypeName() + " Radius: " + radius;
    }

}
