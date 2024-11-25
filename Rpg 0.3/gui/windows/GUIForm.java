package gui.windows;


import javax.swing.*;
import java.awt.*;

public class GUIForm extends JFrame {

    public GUIForm() {
        // Configuración de la ventana
        setTitle("Ventana Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Agregar un panel o componentes aquí
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(new JLabel("Bienvenido a la Ventana Principal"));

        setContentPane(panel);
        setVisible(true); // Hacer visible la ventana
    }
}