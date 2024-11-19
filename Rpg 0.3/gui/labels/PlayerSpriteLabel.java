package gui.labels;

import utils.cache.ImageCache;

import java.awt.*;

public class PlayerSpriteLabel extends PortraitLabel {

    public PlayerSpriteLabel() {

        super();
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("playerSprite", "player/player.png");
        icon = ImageCache.getImageIcon("playerSprite");
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
        setIcon(icon);
    }
}