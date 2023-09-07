package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawCanvas;

import javax.swing.*;
import java.awt.*;

public class Shape extends JPanel {

    private Anchor anchor;
    private Color color;
    private int thickness;
    private boolean filled, selected;

    public Shape(int x, int y) {
        this.anchor = new Anchor(x, y);
        this.color = DrawCanvas.getInstance().getCurrentColor();
        this.thickness = 2;
        this.filled = false;
        this.selected = false;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(thickness));
        g2d.setColor(color);
        anchor.draw(g2d, selected);
    }

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
        anchor.draw((Graphics2D) DrawCanvas.getInstance().getFrame().getGraphics(), selected);
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}
