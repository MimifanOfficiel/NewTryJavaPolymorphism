package fr.mimifan.poly.frames;

import fr.mimifan.poly.listeners.DrawCanvasKeyListener;
import fr.mimifan.poly.listeners.DrawCanvasMouseListener;
import fr.mimifan.poly.shapes.Shape;
import fr.mimifan.poly.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawCanvas {

    private static final DrawCanvas instance = new DrawCanvas();

    private JFrame frame = new JFrame("Polymorphisme");
    private JPanel mainPanel = new JPanel();
    private List<Shape> shapes = new ArrayList<>();
    private Shape currentSelectedShape = null;
    private Color currentColor = Color.BLACK;
    private ColorUtils colorUtils = new ColorUtils();
    private JLabel currentColorLabel = new JLabel("Selected color: " + colorUtils.getColorNameFromColor(currentColor));
    private JLabel locationLabel = new JLabel();

    private final int HEIGHT = 600, WIDTH = 800;


    public void load() {
        buildMainPanel();

        frame.setResizable(false);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new DrawCanvasKeyListener());
        frame.addMouseListener(new DrawCanvasMouseListener());
        frame.addMouseMotionListener(new DrawCanvasMouseListener());

        frame.pack();
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void buildMainPanel(){
        mainPanel.setLayout(null);
        locationLabel.setBounds(10, HEIGHT-100, WIDTH/2, 20);
        currentColorLabel.setBounds(10, HEIGHT-80, WIDTH/2, 20);

        mainPanel.add(locationLabel);
        mainPanel.add(currentColorLabel);
    }


    public JFrame getFrame() { return frame; }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public List<Shape> getShapes() { return shapes; }

    public Shape getCurrentSelectedShape() {
        return currentSelectedShape;
    }

    public Color getCurrentColor() { return currentColor; }

    public void setCurrentColor(Color currentColor) { this.currentColor = currentColor; }

    public void setCurrentSelectedShape(Shape currentSelectedShape) {
        this.currentSelectedShape = currentSelectedShape;
    }

    public JLabel getLocationLabel() {
        return locationLabel;
    }

    public JLabel getCurrentColorLabel() {
        return currentColorLabel;
    }

    public static DrawCanvas getInstance() { return instance; }
}
