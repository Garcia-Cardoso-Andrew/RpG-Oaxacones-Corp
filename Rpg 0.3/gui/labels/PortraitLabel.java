package gui.labels;

import gui.ui.GameLabelUI;
import gui.ui.LabelUI;
import utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta personalizada para mostrar el retrato de un personaje en el juego.
 * Esta clase extiende `JLabel` y se encarga de mostrar un retrato de un personaje con su imagen asociada.
 */
public class PortraitLabel extends JLabel {

    // Icono que representa la imagen del retrato
    protected ImageIcon icon;

    /**
     * Constructor de la clase `PortraitLabel`.
     * Inicializa los componentes y establece la interfaz gráfica asociada a la etiqueta.
     */
    public PortraitLabel() {
        initComponents();
        // Establece la UI personalizada de la etiqueta con las dimensiones preferidas y el icono del retrato
        setUI(new GameLabelUI(getPreferredSize(), icon));
    }

    /**
     * Inicializa los componentes de la etiqueta del retrato.
     * Carga la imagen del retrato desde la caché, establece su tamaño y la coloca en la etiqueta.
     */
    public void initComponents() {
        // Carga la imagen del retrato del personaje desde la caché usando su ruta absoluta
        ImageCache.addImage("portrait", "Personajes/Personaje.png");
        icon = ImageCache.getImageIcon("portrait");

        // Establece el tamaño preferido de la etiqueta para el retrato
        setPreferredSize(new Dimension(117, 117));

        // Establece el icono de la etiqueta como el retrato cargado
        setIcon(icon);
    }
}
