package gui.windows;

import gui.buttons.CreateButton;
import gui.buttons.ExitButton;
import gui.labels.PortraitLabel;
import gui.panels.NewPlayerPanel;

import javax.swing.*;
import java.awt.*;

public class NewFileWindow extends JFrame {

    private int slot;
    private JTextField playerName;
    private JButton cancelButton;
    private JButton createButton;
    private NewPlayerPanel mainPanel;
    private JLabel portraitLabel;
    private JLabel infoLabel;

    public NewFileWindow(int slot) {

        this.slot = slot;
        this.setContentPane(mainPanel);
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        playerName.setFont(new Font("Retron", Font.BOLD, 18));
        playerName.setBackground(new Color(0, 0, 0, 0));
        playerName.setForeground(Color.WHITE);
    }

    private void setContentPane(NewPlayerPanel mainPanel) {

    }

    private void createUIComponents() {
        mainPanel = new NewPlayerPanel();
        portraitLabel = new PortraitLabel();
        infoLabel = new JLabel();
        infoLabel.setOpaque(false);
        infoLabel.setFont(new Font("Retron", Font.BOLD, 18));
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setText("Introduce el nombre de tu personaje:");
        cancelButton = new ExitButton();
        createButton = new CreateButton(slot, this);
    }

    public String getName() {
        return playerName.getText();
    }
}
