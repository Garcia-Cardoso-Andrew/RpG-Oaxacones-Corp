package gui.windows;

import java.awt.*;

public interface WindowConstants {
    // Tamaño de la ventana
    int WINDOW_WIDTH = 800;
    int WINDOW_HEIGHT = 600;

    int EMPTY_BORDER = 40;

    // Margen interno de la ventana
    int WINDOW_INSET = 10; // Margen interno en píxeles

    // Dimensiones del panel medio
    Dimension MIDDLE_DIMENSION = new Dimension(
            WINDOW_WIDTH - 2 * EMPTY_BORDER - 20, // Ancho ajustado
            WINDOW_HEIGHT - 2 * EMPTY_BORDER - 20  // Alto ajustado
    );
}