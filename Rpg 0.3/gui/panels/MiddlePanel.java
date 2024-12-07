package gui.panels;

import gui.ui.UIConstants;
import utils.cache.ImageCache;

import javax.swing.*;

public class MiddlePanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("midPanel",
                "panels/mainBackground.png"));
        setDimension(UIConstants.MIDDLE_DIMENSION);
    }
}
