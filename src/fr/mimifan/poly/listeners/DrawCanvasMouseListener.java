package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.shapes.Shape;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawCanvasMouseListener implements MouseListener, MouseMotionListener {

    private int startX, startY;


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
        if(DrawCanvas.getInstance().getCurrentSelectedShape()== null) return;

        startX = e.getX();
        startY = e.getY();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(DrawCanvas.getInstance().getCurrentSelectedShape() == null) return;

        int deltaX = e.getX() - startX;
        int deltaY = e.getY() - startY;

        DrawCanvas.getInstance().getCurrentSelectedShape().getAnchor().setXY(deltaX, deltaY);
        DrawCanvas.getInstance().getCurrentSelectedShape().setLocation(deltaX, deltaY);

        DrawCanvas.getInstance().getFrame().revalidate();
        DrawCanvas.getInstance().getFrame().repaint();

        DrawCanvas.getInstance().getMainPanel().revalidate();
        DrawCanvas.getInstance().getMainPanel().repaint();
        //DrawCanvas.getInstance().getCurrentSelectedShape().repaintShape();
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
