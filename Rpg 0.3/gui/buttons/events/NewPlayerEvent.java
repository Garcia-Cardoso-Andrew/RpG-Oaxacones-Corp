package gui.buttons.events;

import gui.windows.NewFileWindow;
import gui.windows.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que maneja el evento de creación de un nuevo jugador.
 * Implementa la interfaz ActionListener para gestionar la acción de crear un nuevo jugador.
 */
public class NewPlayerEvent implements ActionListener {

    // Número de la ranura de guardado donde se almacenará la nueva partida
    int slot;
    // Referencia a la ventana de inicio del juego
    StartWindow startWindow;

    /**
     * Constructor de la clase NewPlayerEvent.
     * @param slot número de la ranura de guardado donde se almacenará la nueva partida.
     * @param startWindow ventana de inicio del juego que será cerrada al crear un nuevo jugador.
     */
    public NewPlayerEvent(int slot, StartWindow startWindow) {
        this.slot = slot;
        this.startWindow = startWindow;
    }

    /**
     * Método sobrescrito que se ejecuta cuando se activa el evento de acción.
     * Este método se ejecuta cuando el jugador presiona el botón para crear un nuevo jugador.
     * @param e el evento de acción que se ha producido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cierra la ventana de inicio del juego
        startWindow.dispose();

        // Abre la ventana para crear un nuevo archivo de guardado con la ranura especificada
        new NewFileWindow(slot);
    }
}
