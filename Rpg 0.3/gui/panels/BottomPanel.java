package gui.panels;

import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BottomPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
                "panels/bottomBackground.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION); // Ajusta según sea necesario

        // Establecer el borde vacío con el tamaño de EMPTY_BORDER
        setBorder(new EmptyBorder(0, WindowConstants.EMPTY_BORDER, WindowConstants.EMPTY_BORDER, WindowConstants.EMPTY_BORDER));
    }

    private void setDimension(int middleDimension) {

    }
}