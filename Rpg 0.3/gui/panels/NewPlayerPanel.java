package gui.panels;

import gui.ui.UIConstants;
import utils.cache.ImageCache;

import javax.swing.*;

public class NewPlayerPanel extends BackgroundPanel {

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("borderPanel",
                "panels/borderPanel.png"));
        setDimension(UIConstants.NEW_PLAYER_PANEL_DIMENSION);
    }
}
