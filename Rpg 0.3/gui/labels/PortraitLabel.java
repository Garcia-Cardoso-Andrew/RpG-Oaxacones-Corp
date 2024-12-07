package gui.labels;

import gui.labels.events.ShowStatusEvent;
import gui.ui.GameLabelUI;
import gui.windows.MainWindow;
import utils.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class PortraitLabel extends JLabel {

    protected ImageIcon icon;

    public PortraitLabel() {
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(), icon));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        MainWindow mainWindow = null;
        addMouseListener(new ShowStatusEvent(mainWindow));
    }

    public void initComponents() {
        ImageCache.addImage("portrait", "player/portrait.png");
        icon = ImageCache.getImageIcon("portrait");
        setPreferredSize(
                new Dimension(icon.getIconWidth(),
                        icon.getIconHeight()));
        setIcon(icon);
    }
}
