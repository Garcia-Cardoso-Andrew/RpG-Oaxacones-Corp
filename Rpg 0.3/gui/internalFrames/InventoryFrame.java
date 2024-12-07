package gui.internalFrames;

import gui.ui.UIConstants;
import gui.panels.InternPanel;
import gui.ui.TransparentFrameUI;
import gui.windows.MainWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryFrame extends JInternalFrame {

    private JPanel mainPanel;
    private MainWindow window;
    private Dimension dimension;

    public InventoryFrame(MainWindow window) {

        this.window = window;
        setContentPane(mainPanel);
        dimension = new Dimension(UIConstants.STATUS_FRAME_WIDTH, 600);
        setUI(new TransparentFrameUI(this, dimension));
        setSize(getPreferredSize());
    }

    private void createUIComponents() {
        int displayHeight = 525;
        mainPanel = new JPanel ();
        mainPanel.setBorder(new EmptyBorder(10, 5, 10, 5));
    }
}
