package gui.ui;

import enums.BarType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BarLabel extends BasicLabelUI {

    private final BarType type;

    public BarLabel(BarType type) {
        this.type = type;
    }

    @Override
    protected void installDefaults(JLabel c) {
        c.setOpaque(false);
        c.setBorder(null);
        c.setForeground(Color.WHITE);
        c.setFont(UIConstants.BAR_LABEL_FONT);
        c.setVerticalAlignment(JLabel.BOTTOM);
        c.setVerticalTextPosition(JLabel.BOTTOM);
        c.setHorizontalAlignment(JLabel.RIGHT);
        c.setHorizontalTextPosition(JLabel.RIGHT);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return getBarWidth();
    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getBarWidth();
    }

    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getBarWidth();
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int textMiddle = g.getFontMetrics(g.getFont()).stringWidth(s) / 2;
        g.drawString(s, textX - textMiddle - 5, textY + 3);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        gui.labels.BarLabel barLabel = (gui.labels.BarLabel) c;

        // Cargar imágenes del tipo de barra
        BufferedImage icon = type.getIcon();
        BufferedImage container = type.getContainer();
        BufferedImage bar = type.getBar();

        // Obtener valores de la barra
        int barValue = barLabel.getBarValue();
        int maxValue = barLabel.getMaxValue();

        // Calcular posiciones y dimensiones
        int iconX = 0;
        int iconY = 0;
        int iconWidth = UIConstants.BAR_ICON.width;
        int iconHeight = UIConstants.BAR_ICON.height;
        int displayX = iconWidth - 2;
        int displayY = iconY + 5;
        int displayWidth = UIConstants.BAR_DISPLAY.width;
        int displayHeight = UIConstants.BAR_DISPLAY.height;
        int barWidth = (int) ((double) barValue / maxValue * 157);
        int barHeight = 17;
        int barX = iconWidth + 9;
        int barY = iconY + 15;

        // Dibujar componentes
        g2d.drawImage(icon, iconX, iconY, iconWidth, iconHeight, null);
        g2d.drawImage(container, displayX, displayY, displayWidth, displayHeight, null);
        g2d.drawImage(bar, barX, barY, barWidth, barHeight, null);

        // Llamar al método de superclase para pintar el texto
        super.paint(g, c);
    }

    private Dimension getBarWidth() {
        Dimension iconSize = UIConstants.BAR_ICON;
        Dimension displaySize = UIConstants.BAR_DISPLAY;
        int width = iconSize.width + displaySize.width;
        return new Dimension(width, iconSize.height + 5);
    }
}