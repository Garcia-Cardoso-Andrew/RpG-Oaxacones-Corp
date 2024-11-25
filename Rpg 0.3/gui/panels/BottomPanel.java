package gui.panels;

<<<<<<< Updated upstream
import gui.windows.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BottomPanel extends BackgroundPanel {
=======
import gui.WindowConstants;
import utils.cache.ImageCache;

import javax.swing.*;

public class BottomPanel extends BackgorundPanel {
>>>>>>> Stashed changes

    @Override
    protected void init() {
        // Buscamos la imagen por ahora directamente en los directorios
        backgroundImage = new ImageIcon(ImageCache.addImage("bottomPanel",
<<<<<<< Updated upstream
                "panels/bottomBackground.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION); // Ajusta según sea necesario

        // Establecer el borde vacío con el tamaño de EMPTY_BORDER
        setBorder(new EmptyBorder(0, WindowConstants.EMPTY_BORDER, WindowConstants.EMPTY_BORDER, WindowConstants.EMPTY_BORDER));
    }

    private void setDimension(int middleDimension) {

=======
                "panels/battlePanel.png"));
        setDimension(WindowConstants.MIDDLE_DIMENSION);
        setBorder(WindowConstants.EMPTY_BORDER);
>>>>>>> Stashed changes
    }
}