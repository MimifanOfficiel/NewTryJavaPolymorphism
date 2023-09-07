package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.shapes.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawCanvasMouseListener implements MouseListener, MouseMotionListener {


    @Override
    public void mouseClicked(MouseEvent e) {
        for(Shape s : DrawCanvas.getInstance().getShapes()){
            if(s.isOver(e.getX(), e.getY())){
                DrawCanvas.getInstance().setCurrentSelectedShape(s);
                s.setSelected(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        DrawCanvas.getInstance().getLocationLabel().setText("x: " + e.getX() + ", y: " + e.getY());
    }
}
