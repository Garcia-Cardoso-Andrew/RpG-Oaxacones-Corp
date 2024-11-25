package gui.windows;

import javax.swing.*;
import java.awt.*;

public class JFrame extends javax.swing.JFrame {

    public JFrame() {
        // Set the title of the window
        setTitle("2D RPG Game");

        // Set the size of the window
        setSize(1280, 1024 );

        // Set the default close operation
        setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE);

        // Set the layout manager
        setLayout(new BorderLayout());

        // Create a game panel and add it to the frame
        GamePanel gamePanel = new GamePanel ();
        add(gamePanel, BorderLayout.CENTER);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    // Inner class for the game panel
    private static class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Here you can draw your game elements
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight()); // Background
            g.setColor(Color.RED);
            g.fillRect(100, 100, 50, 50); // Example character sprite
        }
    }

    public static void main(String[] args) {
        // Create the game frame
        SwingUtilities.invokeLater( JFrame::new );
    }
}