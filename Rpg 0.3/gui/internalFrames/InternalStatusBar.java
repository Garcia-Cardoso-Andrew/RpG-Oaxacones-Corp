package gui.internalFrames;

import gui.ui.UIConstants;
import gui.ui.StatusBarUI;
import gui.panels.CenterPanel;
import gui.panels.LeftCornerPanel;
import gui.panels.RightCornerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InternalStatusBar extends JPanel {
    private JPanel leftCornerPanel;
    private JPanel rightCornerPanel;
    private JPanel centerCornerPanel;
    private JPanel mainPanel;
    private JButton button1;
    private JLabel internalTitle;

    public InternalStatusBar(String title, Dimension dimension,
                             JInternalFrame internalFrame) {
        add(mainPanel);
        internalTitle.setText(title);
        internalTitle.setFont(UIConstants.FONT.deriveFont(Font.BOLD, 25f));
        setUI(new StatusBarUI(dimension));
        updateWidth(dimension.width);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                internalFrame.setVisible(false);
            }
        });
    }

    public void updateWidth(int width) {
        mainPanel.setSize(width, UIConstants.INTERNAL_FRAME_HEADER_HEIGHT);
        setSize(width, UIConstants.INTERNAL_FRAME_HEADER_HEIGHT);
        ((CenterPanel) centerCornerPanel).setDimension(new Dimension(width - 100, 77));
    }

    private void createUIComponents() {
        leftCornerPanel = new JPanel ();
        rightCornerPanel = new JPanel ();
        centerCornerPanel = new JPanel ();
    }
}
