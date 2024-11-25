package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder; // Asegúrate de importar esta clase

import static gui.windows.WindowConstants.EMPTY_BORDER;

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel",
                "panels/mainBackground.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);

        // Establecer el borde vacío con el tamaño de EMPTY_BORDER
        setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER, EMPTY_BORDER, EMPTY_BORDER));
    }
}