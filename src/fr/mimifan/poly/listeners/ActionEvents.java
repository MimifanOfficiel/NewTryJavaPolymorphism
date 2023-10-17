package fr.mimifan.poly.listeners;

import fr.mimifan.poly.frames.DrawCanvas;
import fr.mimifan.poly.shapes.Shape;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
                PrintWriter writer;
                try {
                    writer = new PrintWriter(new FileWriter(file), true);
                    for (Shape shape : DrawCanvas.getInstance().getShapes()) writer.println(shape);
                    writer.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }

            case "menu_load" -> {
                File file = selectFile(); if(file == null) return;

            }

        }
    }


    private File selectFile(){
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = selector.showOpenDialog(null);
        if(result != JFileChooser.APPROVE_OPTION) return null;
        return selector.getSelectedFile();
    }


}
