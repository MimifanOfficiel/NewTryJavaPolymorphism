package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingZone;
import fr.mimifan.poly.utils.ColorUtils;

import java.awt.*;

public abstract class Shape {

    private Anchor anchor;
    private Color color;
    private int thickness;
    private boolean filled, selected;

    public Shape(int x, int y) {
        this.anchor = new Anchor(x, y);
        this.color = DrawingZone.getInstance().getCurrentColor();
        this.thickness = 1;
        this.filled = false;
        this.selected = false;
    }


    abstract public void draw(Graphics g);
    abstract public void edit();

    public boolean isOver(int x, int y){
        return anchor.isOver(x, y);
    }


    public Anchor getAnchor() {
        return anchor;
    }

    public int getThickness() {
        return thickness;
    }

    public Color getColor() {
        return color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        anchor.draw(DrawingZone.getInstance().getGraphics(), selected);
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        draw(DrawingZone.getInstance().getGraphics());
    }

    public void setColor(Color color) {
        this.color = color;
        draw(DrawingZone.getInstance().getGraphics());
    }

    public abstract String getTypeName();

    public String toString() {
        return "Shape: Anchor: " + anchor + " Thickness: " + thickness + " Filled: " + filled + " Color: " + new ColorUtils().getColorNameFromColor(getColor()) + " ";
    }

}
