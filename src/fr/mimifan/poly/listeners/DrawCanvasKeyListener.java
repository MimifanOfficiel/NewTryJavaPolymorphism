package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingWindow;
import fr.mimifan.poly.frames.DrawingZone;
import fr.mimifan.poly.shapes.Circle;
import fr.mimifan.poly.shapes.Rectangle;
import fr.mimifan.poly.shapes.Shape;
import fr.mimifan.poly.utils.ColorUtils;

import javax.swing.*;
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
                    Color color = JColorChooser.showDialog(DrawingWindow.getInstance(), "Choisir une couleur", Color.BLACK);
                    DrawingZone.getInstance().setCurrentColor(color);
                    colorKey=true;
                    break;
                case KeyEvent.VK_1:
                    DrawingZone.getInstance().setCurrentColor(Color.BLUE);
                    colorKey=true;
                    break;
                case KeyEvent.VK_2:
                    DrawingZone.getInstance().setCurrentColor(Color.GREEN);
                    colorKey=true;
                    break;
                case KeyEvent.VK_3:
                    DrawingZone.getInstance().setCurrentColor(Color.CYAN);
                    colorKey=true;
                    break;
                case KeyEvent.VK_4:
                    DrawingZone.getInstance().setCurrentColor(Color.RED);
                    colorKey=true;
                    break;
                case KeyEvent.VK_5:
                    DrawingZone.getInstance().setCurrentColor(Color.MAGENTA);
                    colorKey=true;
                    break;
                case KeyEvent.VK_6:
                    DrawingZone.getInstance().setCurrentColor(Color.YELLOW);
                    colorKey=true;
                    break;
                case KeyEvent.VK_7:
                    DrawingZone.getInstance().setCurrentColor(Color.LIGHT_GRAY);
                    colorKey=true;
                    break;
                case KeyEvent.VK_8:
                    DrawingZone.getInstance().setCurrentColor(Color.GRAY);
                    colorKey=true;
                    break;
                case KeyEvent.VK_9:
                    DrawingZone.getInstance().setCurrentColor(Color.WHITE);
                    colorKey=true;
                    break;
                case KeyEvent.VK_R:
                    Rectangle rec = new Rectangle(DrawingWindow.WIDTH / 2,
                            DrawingWindow.HEIGHT / 2, 50, 50);
                    DrawingZone.getInstance().addShape(rec);
                    break;
                case KeyEvent.VK_C:
                    Circle circle = new Circle(DrawingWindow.WIDTH / 2,
                                               DrawingWindow.HEIGHT / 2);
                    DrawingZone.getInstance().addShape(circle);
                    break;
                case KeyEvent.VK_P:
                    if(DrawingZone.getInstance().getCurrentSelectedShape() == null) return;
                    DrawingZone.getInstance().getCurrentSelectedShape().setThickness(DrawingZone.getInstance().getCurrentSelectedShape().getThickness()+1);break;
                case KeyEvent.VK_L:
                    if(DrawingZone.getInstance().getShapes().isEmpty()) {
                        System.out.println("No shapes on the canvas");
                        break;
                    }
                    System.out.println("There " + (DrawingZone.getInstance().getShapes().size() == 1 ? "is 1 shape" : "are " + DrawingZone.getInstance().getShapes().size() + " shapes") + " on the canvas");
                    for(Shape s : DrawingZone.getInstance().getShapes()) System.out.println(s);
                    break;

                case KeyEvent.VK_M:
                     if(DrawingZone.getInstance().getCurrentSelectedShape() == null) return;
                     DrawingZone.getInstance().getCurrentSelectedShape().edit();
                    break;
                case KeyEvent.VK_Q:
                    System.exit(0);
                    break;

            }
            if(colorKey) {
                updateColorLabel();
                if(DrawingZone.getInstance().getCurrentSelectedShape() == null) return;
                DrawingZone.getInstance().getCurrentSelectedShape().setColor(DrawingZone.getInstance().getCurrentColor());
            }
            keysPressed[keyCode] = true;
        }
    }

    public void updateColorLabel(){
        DrawingWindow.getInstance().getCurrentColorLabel().setText("Selected color: " +
                new ColorUtils().getColorNameFromColor(DrawingZone.getInstance().getCurrentColor()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        keysPressed[keyCode] = false;
    }
}
