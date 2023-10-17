package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingWindow;
import fr.mimifan.poly.frames.DrawingZone;
import fr.mimifan.poly.shapes.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawCanvasMouseListener implements MouseListener, MouseMotionListener {

    private int startX, startY;

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Shape s : DrawingZone.getInstance().getShapes()){
            System.out.println(e.getX() + " " + e.getY() + " " + s.getAnchor());
            if(s.isOver(e.getX(), e.getY())){
                DrawingZone.getInstance().setCurrentSelectedShape(s);
                s.setSelected(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(DrawingZone.getInstance().getCurrentSelectedShape() == null) return;

        startX = e.getX();
        startY = e.getY();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(DrawingZone.getInstance().getCurrentSelectedShape() == null) return;

        int deltaX = e.getX() - startX;
        int deltaY = e.getY() - startY;

        DrawingZone.getInstance().getCurrentSelectedShape().getAnchor().setXY(deltaX, deltaY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        DrawCanvas.getInstance().getLocationLabel().setText("x: " + e.getX() + ", y: " + e.getY());
    }
}
