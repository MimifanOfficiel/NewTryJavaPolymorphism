package fr.mimifan.poly.shapes;

import fr.mimifan.poly.dialogs.ShapeEditDialog;
import fr.mimifan.poly.frames.DrawingZone;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends Shape {

    private int width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DrawingZone.getInstance().getCurrentColor());
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(getThickness()));
        g.drawRect(getAnchor().getX(), getAnchor().getY(), width, height);
        getAnchor().draw(g, isSelected());
    }

    @Override
    public void edit() {
        ShapeEditDialog editDialog = new ShapeEditDialog();

        JTextField widthField = new JTextField("Width");
        widthField.setText(String.valueOf(width));

        JTextField heightField = new JTextField("Height");
        heightField.setText(String.valueOf(height));

        JTextField thicknessField = new JTextField("Thickness");
        thicknessField.setText(String.valueOf(getThickness()));

        editDialog.addComponent(new JLabel("Width"), widthField, new JLabel("Height"), heightField, new JLabel("Thickness"), thicknessField);

        if(editDialog.show() != 0) return;
        for (JComponent field : editDialog.getFields()) {
            if(field instanceof JLabel) return;
            if(field instanceof JTextField) System.out.println( ((JTextField) field).getText());
        }


        /*int result = JOptionPane.showConfirmDialog(null, shape_infos, "Edit shape", JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                width = Integer.valueOf(_width.getText());
                height = Integer.valueOf(_height.getText());
                setThickness(Integer.valueOf(_thickness.getText()));
                DrawingZone.getInstance().paint(DrawingZone.getInstance().getGraphics());
            } catch (NumberFormatException e){
                e.printStackTrace();
            }

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }*/
    }

    @Override
    public String getTypeName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return super.toString() + getTypeName() + " Width: " + width + " Height: " + height;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
