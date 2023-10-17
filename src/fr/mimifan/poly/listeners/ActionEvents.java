package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.frames.DrawingWindow;
import fr.mimifan.poly.frames.DrawingZone;
import fr.mimifan.poly.shapes.Shape;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ActionEvents implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "menu_quit" -> {
                if (JOptionPane.showConfirmDialog(null,
                        "Are you willing to quit ?\nAny unsaved changes will be lost",
                        "Closing Application",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }

            case "menu_save" -> {
                File file = selectFile(); if(file == null) return;
                ObjectOutputStream writer;
                try {
                    writer = new ObjectOutputStream(new FileOutputStream(file));
                    for (Shape shape : DrawingZone.getInstance().getShapes()) writer.writeObject(shape);
                    writer.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }

            case "menu_load" -> {
                File file = selectFile(); if(file == null) return;
                try {
                    ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file));
                    for(;;) {
                        try {
                        Shape shape = (Shape) reader.readObject();
                        DrawingZone.getInstance().getShapes().add(shape);
                        } catch (EOFException ex) {return;}
                        DrawingZone.getInstance().paint(DrawingZone.getInstance().getGraphics());
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException("Error while loading shape file.");
                }
            }
        }
    }


    private File selectFile(){
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File("./"));
        selector.setFileFilter(new FileNameExtensionFilter("Shapes binary files", "sbf"));
        int result = selector.showOpenDialog(null);
        if(result != JFileChooser.APPROVE_OPTION) return null;
        return selector.getSelectedFile();
    }


}
