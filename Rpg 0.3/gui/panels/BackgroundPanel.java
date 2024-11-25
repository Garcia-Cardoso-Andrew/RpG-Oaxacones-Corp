package gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class BackgroundPanel extends JPanel {
    // Dimensiones predeterminadas para el panel
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800, 600);

    protected ImageIcon backgroundImage;
    protected Dimension dimension;

    public BackgroundPanel() {
        this.dimension = DEFAULT_DIMENSION; // Establecer dimensión predeterminada
        init();
    }

    protected abstract void init();

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Configuraciones de renderizado
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // Dibujar la imagen de fondo si no es nula y la dimensión está establecida
        if (backgroundImage != null && dimension != null) {
            g2d.drawImage(backgroundImage.getImage(), 0, 0, dimension.width, dimension.height, null);
        }
    }
}