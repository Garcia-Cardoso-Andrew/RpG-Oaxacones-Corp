package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que representa el panel para la creación de un nuevo jugador en la interfaz de usuario.
 * Este panel es una subclase de `BackgroundPanel` y se encarga de configurar su fondo y tamaño.
 */
public class NewPlayerPanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel para la creación de un nuevo jugador.
     * Establece la imagen de fondo y las dimensiones del panel según las configuraciones predefinidas.
     */
    @Override
    protected void init() {
        // Carga la imagen de fondo del panel desde la caché de imágenes utilizando la ruta correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel", "panels/borderPanel.png"));

        // Establece las dimensiones del panel para la creación de un nuevo jugador según una constante definida en `WindowConstants`
        setDimension(WindowConstants.NEW_PLAYER_PANEL_DIMENSION);
    }
}
