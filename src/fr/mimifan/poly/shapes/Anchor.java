package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingZone;

import java.awt.*;

public class Anchor {

    private int x, y;

    public Anchor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g, boolean selected) {
        if(!selected) g.setColor(Color.BLACK);
        else g.setColor(Color.PINK);

        if(!selected) g.drawRect(x-2, y-2, 4, 4);
        else g.fillRect(x-2, y-2, 4, 4);
    }

    public boolean isOver(int x, int y){
        int size = 4;
        return ((this.x>x ? this.x-x : x-this.x) <= size && (this.y>y ? this.y-y : y-this.y) <= size);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
        DrawingZone.getInstance().paint(DrawingZone.getInstance().getGraphics());
    }


    public String toString(){
        return getX() + " " + getY();
    }
}
