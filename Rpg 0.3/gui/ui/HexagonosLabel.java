package gui.ui;

import gui.labels.PortraitLabel;
import utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;
import gui.windows.WindowConstants;

public class HexagonosLabel extends PortraitLabel {

    public HexagonosLabel() {
        super();
        setFont(WindowConstants.LABEL_FONT.deriveFont(Font.BOLD, 20f));
        setForeground(Color.BLACK);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        setHorizontalTextPosition(JLabel.CENTER);
    }

    @Override
    public void initComponents() {
        ImageCache.addImage("gold", "labels/goldLabel.png");
        icon = ImageCache.getImageIcon("gold");
        setPreferredSize(new Dimension(
                icon.getIconWidth(), icon.getIconHeight()));
        setIcon(icon);
        setText("1000");
    }
}