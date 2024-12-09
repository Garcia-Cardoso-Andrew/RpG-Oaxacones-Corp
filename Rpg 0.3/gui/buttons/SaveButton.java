package gui.buttons;

import entities.Player.Player;
import gui.windows.MainWindow;

/**
 * Clase que representa un botón para guardar la partida.
 * Este botón guarda el estado actual del jugador en un archivo de guardado.
 */
public class SaveButton extends BaseButton {

    /**
     * Constructor que inicializa el botón de guardar partida.
     *
     * @param window La ventana principal del juego donde se muestra el botón.
     * @param player El jugador cuya partida se va a guardar.
     * @param slot El slot donde se guardará la partida.
     */
    public SaveButton(MainWindow window, Player player, int slot) {
        // Llama al constructor de la clase base (BaseButton) con el texto "Guardar".
        super("Guardar");

        // Añade un action listener que guarda la partida cuando el botón es presionado.
        addActionListener(e -> {
            // Guarda la partida del jugador en el slot especificado.
            player.save(slot);

            // Muestra un mensaje en la ventana principal indicando que la partida se ha guardado correctamente.
            window.appendText("""
                    Partida guardada correctamente.
                    """);
        });
    }
}