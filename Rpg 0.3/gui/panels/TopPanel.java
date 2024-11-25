package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TopPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("topPanel", "panels/topBackground.png"));

        // Ajusta según sea necesario
        setDimension(WindowConstants.TOP_DIMENSION);

        // Establecer el borde vacío con el tamaño de EMPTY_BORDER
        setBorder(new EmptyBorder(WindowConstants.EMPTY_BORDER, WindowConstants.EMPTY_BORDER, 0, WindowConstants.EMPTY_BORDER));
    }
}