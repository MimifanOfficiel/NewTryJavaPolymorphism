package fr.mimifan.poly.frames;

import fr.mimifan.poly.listeners.ActionEvents;
import fr.mimifan.poly.listeners.ColorActionEvent;
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

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new DrawCanvasKeyListener());
        frame.addMouseListener(new DrawCanvasMouseListener());
        frame.addMouseMotionListener(new DrawCanvasMouseListener());


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("Fichier");
        JMenu color = new JMenu("Couleur");

        menuBar.add(file);
        menuBar.add(color);

        file.addSeparator();
        color.addSeparator();


        JMenuItem load = new JMenuItem("Charger");
        JMenuItem save = new JMenuItem("Sauvegarder");
        JMenuItem quit =new JMenuItem("Quitter");


        JMenuItem black = new JMenuItem("Noir");
        JMenuItem red = new JMenuItem("Rouge");
        JMenuItem blue = new JMenuItem("Bleu");
        JMenuItem custom = new JMenuItem("Personnalisée");


        file.add(load);
        file.add(save);

        color.add(black);
        color.add(red);
        color.add(blue);

        file.addSeparator();
        color.addSeparator();


        file.add(quit);
        color.add(custom);

        quit.setActionCommand("menu_quit");
        quit.addActionListener(new ActionEvents());

        load.setActionCommand("menu_load");
        load.addActionListener(new ActionEvents());

        save.setActionCommand("menu_save");
        save.addActionListener(new ActionEvents());

        black.setActionCommand("menu_black");
        red.setActionCommand("menu_red");
        blue.setActionCommand("menu_blue");
        custom.setActionCommand("menu_custom");

        black.addActionListener(new ColorActionEvent());
        red.addActionListener(new ColorActionEvent());
        blue.addActionListener(new ColorActionEvent());
        custom.addActionListener(new ColorActionEvent());




        frame.pack();
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void buildMainPanel(){
        mainPanel.setLayout(null);
        mainPanel.setOpaque(false);
        locationLabel.setBounds(10, HEIGHT-100, WIDTH/6, 20);
        currentColorLabel.setBounds(10, HEIGHT-80, WIDTH/5, 20);

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
