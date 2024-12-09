package gui.buttons;

import gui.buttons.events.NewFileEvent;
import gui.windows.NewFileWindow;

/**
 * Clase que representa un botón para crear un nuevo archivo de jugador.
 * Hereda de la clase BaseButton y añade el evento que se ejecuta al hacer clic en el botón.
 */
public class CreateButton extends BaseButton {

    /**
     * Constructor de la clase CreateButton.
     * Inicializa el botón con el texto "¡A la aventura!" y asigna un evento que se ejecuta al hacer clic.
     * @param slot El número de ranura donde se guardará el nuevo archivo.
     * @param window La ventana donde se creará el nuevo archivo de jugador.
     */
    public CreateButton(int slot, NewFileWindow window) {

        // Llama al constructor de BaseButton para establecer el texto del botón
        super("¡A la aventura!");

        // Añade un ActionListener al botón que ejecutará el evento de crear un nuevo archivo
        addActionListener(new NewFileEvent(slot, window));
    }


}
