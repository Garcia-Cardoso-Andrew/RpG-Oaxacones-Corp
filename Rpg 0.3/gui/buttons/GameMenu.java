package gui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu() {
        // Configuración de la ventana
        setTitle("Menú del Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new GridLayout(4, 1)); // Usar GridLayout para organizar los botones

        // Crear botones
        JButton saveButton = createButton("Guardar", e -> saveGame());
        JButton exitButton = createButton("Salir", e -> exitGame());
        JButton inventoryButton = createButton("Inventario", e -> showInventory());
        JButton statsButton = createButton("Estadísticas", e -> showStats());

        // Añadir botones a la ventana
        add(saveButton);
        add(exitButton);
        add(inventoryButton);
        add(statsButton);

        // Hacer visible la ventana
        setVisible(true);
    }

    private JButton createButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }

    private void saveGame() {
        // Lógica para guardar la partida
        JOptionPane.showMessageDialog(this, "Partida guardada.");
    }

    private void exitGame() {
        // Lógica para salir del juego
        int confirmed = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que quieres salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void showInventory() {
        // Lógica para mostrar el inventario
        JOptionPane.showMessageDialog(this, "Accediendo al inventario...");
    }

    private void showStats() {
        // Lógica para mostrar las estadísticas
        JOptionPane.showMessageDialog(this, "Mostrando estadísticas del personaje...");
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(GameMenu::new);
    }
}