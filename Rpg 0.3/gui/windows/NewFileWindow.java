package gui.windows;

import gui.buttons.CreateButton;
import gui.buttons.ExitButton;
import gui.labels.PortraitLabel;
import gui.panels.NewPlayerPanel;

import javax.swing.*;
import java.awt.*;

public class NewFileWindow extends JFrame {

    private int slot; // Identificador del slot del jugador
    private JTextField playerName; // Campo de texto para ingresar el nombre del jugador
    private JButton cancelButton; // Botón de cancelar
    private JButton createButton; // Botón de crear jugador
    private JPanel mainPanel; // Panel principal
    private JLabel portraitLabel; // Etiqueta para el retrato del jugador
    private JLabel infoLabel; // Etiqueta de instrucciones

    public NewFileWindow(int slot) {
        this.slot = slot;

        // Inicializa los componentes de la interfaz
        createUIComponents();

        // Configura el panel principal
        this.setContentPane(mainPanel);

        // Ajusta la ventana
        pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        // Configura el campo de texto para el nombre del jugador
        playerName.setFont(new Font("Retron", Font.BOLD, 18));
        playerName.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
        playerName.setForeground(Color.WHITE); // Texto blanco
    }

    private void createUIComponents() {
        // Crea el panel principal personalizado
        mainPanel = new NewPlayerPanel();
        mainPanel.setLayout(new BorderLayout()); // Layout para organizar componentes

        // Crea el retrato del jugador
        portraitLabel = new PortraitLabel();

        // Configura el label de información
        infoLabel = new JLabel("Introduce el nombre de tu personaje:");
        infoLabel.setOpaque(false);
        infoLabel.setFont(new Font("Retron", Font.BOLD, 18));
        infoLabel.setForeground(Color.WHITE);

        // Configura el campo de texto
        playerName = new JTextField(20);

        // Configura los botones
        cancelButton = new ExitButton();
        createButton = new CreateButton(slot, this);

        // Organiza los componentes en el panel principal
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setOpaque(false);
        topPanel.add(infoLabel);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(playerName);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(cancelButton);
        bottomPanel.add(createButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(portraitLabel, BorderLayout.WEST); // Agrega el retrato al lado izquierdo
    }
public String getName() {
        // Devuelve el nombre ingresado por el usuario
        return playerName.getText();
    }
}
