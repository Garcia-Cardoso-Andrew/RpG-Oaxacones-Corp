package gui.panels;

import gui.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

public class BottomPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
                "panels/battlePanel.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
    }
}