package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que representa el panel inferior del juego, el cual se utiliza para mostrar botones u otros
 * componentes interactivos en la parte inferior de la interfaz.
 * Esta clase extiende `BackgroundPanel` y se encarga de configurar el fondo y el tamaño del panel.
 */
public class BottomPanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel inferior.
     * Se establece la imagen de fondo y las propiedades de tamaño y borde del panel.
     */
    @Override
    protected void init() {
        // Carga la imagen de fondo del panel desde la caché de imágenes usando su ruta específica
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel", "Paneles/ButtonPanel.png"));

        // Establece las dimensiones del panel según las constantes definidas en `WindowConstants`
        setDimension(WindowConstants.MIDDLE_DIMENSION);

        // Establece un borde vacío para el panel, según la configuración de `WindowConstants`
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}