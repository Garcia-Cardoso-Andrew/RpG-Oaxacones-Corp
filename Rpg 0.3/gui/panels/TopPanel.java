package gui.panels;

import utils.cache.ImageCache;
import gui.windows.WindowConstants;

import javax.swing.*;

/**
 * Clase que representa el panel superior de la interfaz de usuario.
 * Este panel es una subclase de `BackgroundPanel` y se encarga de configurar su fondo y tamaño.
 */
public class TopPanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel superior.
     * Establece la imagen de fondo y las dimensiones del panel según las configuraciones predefinidas.
     */
    @Override
    protected void init() {
        // Carga la imagen de fondo del panel superior desde la caché de imágenes utilizando la ruta correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel", "Paneles/TopPanel.png"));

        // Establece las dimensiones del panel superior según una constante definida en `WindowConstants`
        setDimension(WindowConstants.TOP_DIMENSION);

        // Establece un borde vacío para el panel
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}