package gui.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class LabelUI extends BasicLabelUI {

    private final Dimension size;
    ImageIcon icon;

    public LabelUI(Dimension size, ImageIcon icon) {

        this.size = size;
        this.icon = icon;
    }

    @Override
    protected void installDefaults(JLabel c) {

        c.setOpaque(false);
        c.setBorder(null);
    }
}