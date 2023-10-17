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
        g.setColor(getColor());
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

        JLabel colorLabel = new JLabel("Color");
        JColorChooser colorChooser = new JColorChooser();

        final JComponent[] shape_infos = new JComponent[] {
                widthField,
                heightField,
                thicknessField,
                colorLabel,
                colorChooser
        };

        int result = JOptionPane.showConfirmDialog(null, shape_infos, "Edit shape", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                width = Integer.parseInt(widthField.getText());
                height = Integer.parseInt(heightField.getText());
                setThickness(Integer.parseInt(thicknessField.getText()));
                setColor(colorChooser.getColor());
                DrawingZone.getInstance().paint(DrawingZone.getInstance().getGraphics());
            } catch (Exception ignored) {}

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
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
