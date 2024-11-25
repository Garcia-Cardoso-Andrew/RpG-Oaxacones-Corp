package gui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BaseButton extends JButton {

    public BaseButton(String text) {
        super(text);
        initButton();
    }

    private void initButton() {
        // Configuraciones iniciales del botón
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
    }

    // Método para agregar un ActionListener
    public void addAction(ActionListener actionListener) {
        addActionListener(actionListener);
    }

    // Método para cambiar el texto del botón
    public void setButtonText(String text) {
        setText(text);
    }

    // Método para habilitar o deshabilitar el botón
    public void setEnabledState(boolean enabled) {
        setEnabled(enabled);
    }

    // Método para establecer el color de fondo
    public void setButtonBackground(Color color) {
        setBackground(color);
    }

    // Método para establecer el color del texto
    public void setButtonForeground(Color color) {
        setForeground(color);
    }

    protected abstract void initIcons();
}