package gui.windows;

import utils.cache.FontCache;

import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 * Esta interfaz contiene constantes relacionadas con las configuraciones y dimensiones de la ventana y los elementos de la UI.
 * Incluye tamaños de ventana, márgenes, fuentes, y dimensiones específicas para diferentes paneles y componentes gráficos.
 */
public interface WindowConstants {

    // Tamaño de la ventana principal
    Dimension WINDOW_SIZE = new Dimension(1000, 500); // Tamaño total de la ventana
    Insets WINDOW_INSETS = new Insets(10, 10, 10, 10); // Márgenes de la ventana
    Font DEFAULT_FONT = FontCache.getFont("Arial", Font.PLAIN, 12); // Fuente predeterminada
    Font BAR_LABEL_FONT = FontCache.getFont("Arial", Font.PLAIN, 16).deriveFont(16f); // Fuente para las barras (más grande)
    Font LABEL_FONT = FontCache.getFont("Arial", Font.BOLD, 18).deriveFont(Font.BOLD, 18f); // Fuente para etiquetas con estilo en negrita

    // Dimensiones específicas de la ventana
    int WINDOW_WIDTH = 1200; // Ancho total de la ventana
    int TOP_HEIGHT = 150; // Altura del panel superior
    int MIDDLE_HEIGHT = 320; // Altura del panel central
    int BOTTOM_HEIGHT = 350; // Altura del panel inferior
    int SIMPLE_MARGIN = 18; // Margen simple para algunos componentes
    int CORNER_WIDTH = 52; // Ancho de las esquinas (para bordes redondeados o componentes específicos)
    int CORNER_HEIGHT = 77; // Altura de las esquinas
    int CENTER_WIDTH = 350 - 2 * CORNER_WIDTH; // Ancho central de la ventana, ajustado por las esquinas

    // Dimensiones de las barras de vida o similar
    Dimension BAR_ICON = new Dimension(58, 58); // Dimensiones del icono de la barra
    Dimension BAR_DISPLAY = new Dimension(179, 58); // Dimensiones de la barra de visualización de la barra

    // Dimensiones específicas de los paneles
    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT); // Dimensiones del panel superior
    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT); // Dimensiones del panel central
    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT); // Dimensiones del panel inferior
    Dimension CORNER_DIMENSION = new Dimension(52, 77); // Dimensiones de las esquinas
    Dimension CENTER_DIMENSION = new Dimension(CENTER_WIDTH, 77); // Dimensiones del área central

    // Dimensiones de etiquetas de barra
    Dimension BAR_LABEL = new Dimension(172, 51); // Dimensiones para etiquetas relacionadas con barras

    // Borde vacío utilizado en algunos componentes
    EmptyBorder EMPTY_BORDER = new EmptyBorder(14, SIMPLE_MARGIN, SIMPLE_MARGIN, SIMPLE_MARGIN);

    // Otras dimensiones para paneles específicos
    Dimension START_WINDOW_DIMENSION = new Dimension(800, 600); // Dimensiones para la ventana de inicio
    Dimension FILES_PANEL_DIMENSION = new Dimension(786, 563); // Dimensiones para el panel de archivos
    Dimension NEW_PLAYER_PANEL_DIMENSION = new Dimension(786, 250); // Dimensiones para el panel de nuevo jugador

}
