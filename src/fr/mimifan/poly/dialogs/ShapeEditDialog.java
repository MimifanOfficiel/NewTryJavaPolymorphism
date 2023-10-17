package fr.mimifan.poly.dialogs;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShapeEditDialog {

    private List<JComponent> fields = new ArrayList<>();
    private JButton color;
    private int thickness;

    private String title = "Edit Shape";
    private int messageType;
    private JRootPane rootPane;
    private String[] options;
    private int optionIndex;


    public ShapeEditDialog() {
        setMessageType(JOptionPane.PLAIN_MESSAGE);
        setRootPane(null);
        setOptions(new String[] { "OK", "Cancel" });
        setOptionSelection(0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public void addComponent(JComponent component) {
        fields.add(component);
    }

    public void addMessageText(String messageText) {
        JLabel label = new JLabel("<html>" + messageText + "</html>");

        fields.add(label);
    }

    public void setRootPane(JRootPane rootPane)  {
        this.rootPane = rootPane;
    }

    public void setOptions(String[] options)  {
        this.options = options;
    }

    public void setOptionSelection(int optionIndex)  {
        this.optionIndex = optionIndex;
    }

    public int show() {
        int optionType = JOptionPane.OK_CANCEL_OPTION;
        Object optionSelection = null;

        if(options.length != 0) {
            optionSelection = options[optionIndex];
        }

        fields.add(new JLabel("Color"));
        fields.add(new JColorChooser());

        int selection = JOptionPane.showOptionDialog(rootPane,
                fields.toArray(), title, optionType, messageType, null,
                options, optionSelection);

        return selection;
    }

    public static String getLineBreak()  {
        return "<br>";
    }

    public List<JComponent> getFields() {
        return fields;
    }
}
