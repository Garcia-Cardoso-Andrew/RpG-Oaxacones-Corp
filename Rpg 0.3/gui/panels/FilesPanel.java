package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Clase que representa el panel de archivos, donde se pueden ver las opciones de cargar o guardar partidas.
 * Esta clase extiende `BackgroundPanel` y se encarga de establecer el fondo y el tamaño del panel.
 */
public class FilesPanel extends BackgroundPanel {

    /**
     * Inicializa los componentes del panel de archivos.
     * Establece la imagen de fondo y las dimensiones del panel según las configuraciones predefinidas.
     */
    @Override
    protected void init() {
        // Carga la imagen de fondo del panel desde la caché de imágenes usando la ruta correspondiente
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel", "Paneles/borderPanel.png"));

        // Establece las dimensiones del panel de archivos según una constante definida en `WindowConstants`
        setDimension(WindowConstants.FILES_PANEL_DIMENSION);
    }
}
