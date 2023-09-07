package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.shapes.Rectangle;
import fr.mimifan.poly.utils.ColorUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawCanvasKeyListener implements KeyListener {

    private boolean[] keysPressed = new boolean[1024];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (!keysPressed[keyCode]) {
            boolean colorKey = false;
            switch (keyCode) {
                case KeyEvent.VK_0:
                    DrawCanvas.getInstance().setCurrentColor(Color.BLACK);
                    colorKey=true;
                    break;
                case KeyEvent.VK_1:
                    DrawCanvas.getInstance().setCurrentColor(Color.BLUE);
                    colorKey=true;
                    break;
                case KeyEvent.VK_2:
                    DrawCanvas.getInstance().setCurrentColor(Color.GREEN);
                    colorKey=true;
                    break;
                case KeyEvent.VK_3:
                    DrawCanvas.getInstance().setCurrentColor(Color.CYAN);
                    colorKey=true;
                    break;
                case KeyEvent.VK_4:
                    DrawCanvas.getInstance().setCurrentColor(Color.RED);
                    colorKey=true;
                    break;
                case KeyEvent.VK_5:
                    DrawCanvas.getInstance().setCurrentColor(Color.MAGENTA);
                    colorKey=true;
                    break;
                case KeyEvent.VK_6:
                    DrawCanvas.getInstance().setCurrentColor(Color.YELLOW);
                    colorKey=true;
                    break;
                case KeyEvent.VK_7:
                    DrawCanvas.getInstance().setCurrentColor(Color.LIGHT_GRAY);
                    colorKey=true;
                    break;
                case KeyEvent.VK_8:
                    DrawCanvas.getInstance().setCurrentColor(Color.GRAY);
                    colorKey=true;
                    break;
                case KeyEvent.VK_9:
                    DrawCanvas.getInstance().setCurrentColor(Color.WHITE);
                    colorKey=true;
                    break;
                case KeyEvent.VK_R:
                    Rectangle rec = new Rectangle(DrawCanvas.getInstance().getFrame().getWidth() / 2,
                            DrawCanvas.getInstance().getFrame().getHeight() / 2, 50, 50);
                    DrawCanvas.getInstance().getMainPanel().add(rec);
                    DrawCanvas.getInstance().getShapes().add(rec);
                    break;
                case KeyEvent.VK_P:
                    if(DrawCanvas.getInstance().getCurrentSelectedShape() == null) return;
                    DrawCanvas.getInstance().getCurrentSelectedShape().setThickness(DrawCanvas.getInstance().getCurrentSelectedShape().getThickness()+1);
                case KeyEvent.VK_Q:
                    System.exit(0);
                    break;

            }
            if(colorKey) updateColorLabel();
            keysPressed[keyCode] = true;
        }
    }

    public void updateColorLabel(){
        DrawCanvas.getInstance().getCurrentColorLabel().setText("Selected color: " +
                new ColorUtils().getColorNameFromColor(DrawCanvas.getInstance().getCurrentColor()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keysPressed[keyCode] = false;
    }
}
