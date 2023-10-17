package fr.mimifan.poly.frames;

import fr.mimifan.poly.listeners.ActionEvents;
import fr.mimifan.poly.listeners.ColorActionEvent;
import fr.mimifan.poly.listeners.DrawCanvasKeyListener;
import fr.mimifan.poly.listeners.DrawCanvasMouseListener;
import fr.mimifan.poly.utils.ColorUtils;

import javax.swing.*;

public class DrawingWindow extends JFrame {

    private static DrawingWindow instance = null;

    public static final int HEIGHT = 600, WIDTH = 800;

    private ColorUtils colorUtils = new ColorUtils();
    private JLabel currentColorLabel = new JLabel("Selected color: ");
    private JLabel locationLabel = new JLabel();

    public DrawingWindow(){
        instance = this;
        setTitle("Polymorphisme en Java !");
        setLayout(null);
        setResizable(true);
        setContentPane(new DrawingZone());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(new DrawCanvasKeyListener());
        addMouseListener(new DrawCanvasMouseListener());
        addMouseMotionListener(new DrawCanvasMouseListener());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu file = new JMenu("Fichier");
        JMenu color = new JMenu("Couleur");

        menuBar.add(file);
        menuBar.add(color);

        file.addSeparator();
        color.addSeparator();


        JMenuItem load = new JMenuItem("Charger");
        JMenuItem save = new JMenuItem("Sauvegarder");
        JMenuItem quit = new JMenuItem("Quitter");


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

        pack();
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static DrawingWindow getInstance() {
        return instance;
    }

    public JLabel getCurrentColorLabel() {
        return currentColorLabel;
    }
}
