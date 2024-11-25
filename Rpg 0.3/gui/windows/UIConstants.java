package gui.windows;

import utils.cache.FontCache;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UIConstants {
    // Fuentes
    public static final Font FONT = FontCache.addFont("PIXM", "fonts/M6X.ttf");
    public static final Font BAR_LABEL_FONT = FontCache.addFont("PAE", "fonts/PixelAE.ttf").deriveFont(16f);
    public static final Font LABEL_FONT = FontCache.addFont("Retron", "fonts/Retron2000.ttf").deriveFont(Font.BOLD, 18f);

    // Dimensiones de la ventana
    public static final int WINDOW_WIDTH = 1500;
    public static final int TOP_HEIGHT = 150;
    public static final int MIDDLE_HEIGHT = 320;
    public static final int BOTTOM_HEIGHT = 350;

    // Margen y dimensiones
    public static final int SIMPLE_MARGIN = 18;
    public static final int CORNER_WIDTH = 52;
    public static final int CORNER_HEIGHT = 77;
    public static final int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH;

    // Dimensiones de componentes
    public static final Dimension BAR_ICON = new Dimension(58, 58);
    public static final Dimension BAR_DISPLAY = new Dimension(179, 58);
    public static final Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);
    public static final Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);
    public static final Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);
    public static final Dimension CORNER_DIMENSION = new Dimension(CORNER_WIDTH, CORNER_HEIGHT);
    public static final Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, CORNER_HEIGHT);
    public static final Dimension BAR_LABEL = new Dimension(172, 51);
    public static final EmptyBorder EMPTY_BORDER = new EmptyBorder(14, SIMPLE_MARGIN, SIMPLE_MARGIN, SIMPLE_MARGIN);

    // Textos de botones
    public static final String BUTTON_1_TEXT = "Button 1";
    public static final String TIENDAS_BUTTON_TEXT = "Tiendas";
    public static final String INVENTARIO_BUTTON_TEXT = "Inventario";
    public static final String ATACAR_BUTTON_TEXT = "Atacar";
    public static final String HABILIDADES_BUTTON_TEXT = "Habilidades";
    public static final String HUIR_BUTTON_TEXT = "Huir";
}