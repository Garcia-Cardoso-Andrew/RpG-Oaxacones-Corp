package gui.buttons;

import gui.windows.MainWindow;

/**
 * Clase que representa un botón para intentar huir del combate.
 * Hereda de la clase BaseButton y asigna el evento de huida al hacer clic en el botón.
 */
public class FleeButton extends BaseButton {

    /**
     * Constructor de la clase FleeButton.
     * Inicializa el botón con el texto "Huir" y asigna un evento que intenta huir del combate al hacer clic.
     *
     * @param game Instancia de la ventana principal del juego (MainWindow).
     */
    public FleeButton(MainWindow game) {

        // Llama al constructor de BaseButton para establecer el texto del botón
        super("Huir");

        // Añade un ActionListener al botón que ejecutará el intento de huir del combate
        addActionListener(e -> game.tryToFlee());
    }
}