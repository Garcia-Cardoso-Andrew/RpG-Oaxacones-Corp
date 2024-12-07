package gui.labels;

import gui.ui.NameLabelUI;

import javax.swing.*;

public class NameLabel extends JLabel {

    public NameLabel(String name) {
        super(name);
        setUI(new NameLabelUI());
    }

    public void updateLabel(String name) {

    }
}