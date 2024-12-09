package gui.buttons;

import entities.Player.Player;
import gui.windows.MainWindow;
import utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase base para la creación de botones personalizados en la interfaz gráfica.
 * Extiende la clase JButton y establece el comportamiento básico de los botones en el juego.
 */
public  class BaseButton extends JButton {

    /**
     * Constructor de la clase BaseButton.
     * Inicializa el botón con el texto proporcionado y aplica una interfaz personalizada de botón con efectos de hover.
     * @param text El texto que aparecerá en el botón.
     */
    public BaseButton(String text) {

        // Establece el texto del botón
        setText(text);

        // Aplica un estilo personalizado al botón, que incluye efectos visuales cuando el ratón pasa sobre él (hover)
        setUI(new HoverButtonUI());
    }

    public BaseButton(MainWindow mainWindow, Player player, int slot) {
    }

    public BaseButton() {

    }

    protected void initIcons() {

    }
}