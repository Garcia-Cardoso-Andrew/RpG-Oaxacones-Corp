package gui.buttons;

import gui.windows.MainWindow;
import gui.buttons.events.AttackEvent;

/**
 * Clase que representa el botón de "Atacar" en la interfaz del juego.
 * Extiende la clase BaseButton y asocia el evento de ataque al presionar el botón.
 */
public class AttackButton extends BaseButton {

    /**
     * Constructor de la clase Atacar.
     * Inicializa el botón con el texto "Atacar" y asocia el evento de ataque.
     * @param game ventana principal del juego que será utilizada por el evento de ataque.
     */
    public AttackButton(MainWindow game) {

        // Llama al constructor de la clase base para establecer el texto del botón
        super("Atacar");

        // Añade el listener de acción, que ejecutará el evento de ataque cuando se presione el botón
        addActionListener(new AttackEvent(game));
    }
}
