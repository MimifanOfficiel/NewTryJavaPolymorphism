package fr.mimifan.poly.shapes;

import fr.mimifan.poly.frames.DrawingZone;

import javax.swing.*;
import java.awt.*;

public class Circle extends Shape {

    private int radius;

    public Circle(int x, int y) {
        super(x, y);
        this.radius = 50;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(DrawingZone.getInstance().getCurrentColor());
        ((Graphics2D) g).setStroke(new BasicStroke(getThickness()));
        g.drawOval(getAnchor().getX(), getAnchor().getY(), radius, radius);
        getAnchor().draw(g, isSelected());
    }

    @Override
    public void edit() {

        JTextField radiusField = new JTextField("Radius");
        radiusField.setText(String.valueOf(radius));

        JTextField thicknessField = new JTextField("Thickness");
        thicknessField.setText(String.valueOf(getThickness()));

        JLabel colorLabel = new JLabel("Color");
        JColorChooser colorChooser = new JColorChooser();

        final JComponent[] shape_infos = new JComponent[] {
                radiusField,
                thicknessField,
                colorLabel,
                colorChooser
        };

        int result = JOptionPane.showConfirmDialog(null, shape_infos, "Edit shape", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                radius = Integer.parseInt(radiusField.getText());
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
        return "Circle";
    }

    @Override
    public String toString() {
        return super.toString() + getTypeName() + " Radius: " + radius;
    }

}
