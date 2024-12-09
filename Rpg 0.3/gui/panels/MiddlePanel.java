package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que representa el panel central de la interfaz de usuario.
 * Este panel es una subclase de `BackgroundPanel` y se encarga de configurar su fondo y tamaño.
 */
public class MiddlePanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel central.
     * Establece la imagen de fondo y las dimensiones del panel según las configuraciones predefinidas.
     */
    @Override
    protected void init() {
        // Carga la imagen de fondo del panel central desde la caché de imágenes usando la ruta correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel", "Paneles/MiddlePanel.png"));

        // Establece las dimensiones del panel central según una constante definida en `WindowConstants`
        setDimension(WindowConstants.MIDDLE_DIMENSION);

        // Establece el borde del panel como vacío, utilizando una constante predefinida
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}