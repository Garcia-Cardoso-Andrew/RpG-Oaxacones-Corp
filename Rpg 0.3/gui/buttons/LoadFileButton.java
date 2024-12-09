package gui.buttons;

import gui.windows.StartWindow;
import gui.buttons.events.LoadFileEvent;

/**
 * Clase que extiende de NewFileButton, representa un botón para cargar una partida guardada.
 * Hereda de NewFileButton pero cambia el texto del botón y su comportamiento al hacer clic.
 */
public class LoadFileButton extends NewFileButton {

    /**
     * Constructor para inicializar el botón de cargar partida.
     *
     * @param slot El slot de la partida guardada que se desea cargar.
     * @param startWindow La ventana de inicio donde se encuentra el botón.
     */
    public LoadFileButton(int slot, StartWindow startWindow) {
        super(slot, startWindow);  // Llama al constructor de la clase base NewFileButton

        // Cambia el texto del botón a "Cargar Partida"
        setText("Cargar Partida");

        // Elimina el action listener que se había añadido en el constructor de la clase base.
        removeActionListener(getActionListeners()[0]);

        // Añade un nuevo action listener para cargar la partida al hacer clic en el botón.
        addActionListener(new LoadFileEvent(slot, startWindow));
    }
}
