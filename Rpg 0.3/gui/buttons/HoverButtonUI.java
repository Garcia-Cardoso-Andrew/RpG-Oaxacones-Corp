package gui.buttons;

import utils.cache.FontCache;
import utils.cache.ImageCache;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * Clase personalizada para el estilo de los botones con efecto hover.
 * Extiende la clase BasicButtonUI para personalizar el aspecto de los botones.
 */
public class HoverButtonUI extends BasicButtonUI {

    // Variables para almacenar las dimensiones y las imágenes del botón
    protected int width;
    protected int dwidth;
    protected int height;
    protected ImageIcon[] parts;       // Imágenes para el estado normal del botón
    protected ImageIcon[] partsHover;  // Imágenes para el estado hover (cuando el mouse pasa sobre el botón)

    /**
     * Método que establece los valores predeterminados para el botón.
     * Se inicializan las imágenes y el comportamiento del botón.
     *
     * @param b El botón al que se le aplicarán los valores predeterminados.
     */
    @Override
    protected void installDefaults(AbstractButton b) {

        // Inicializa las imágenes para los diferentes estados del botón
        initParts();

        // Configura las propiedades visuales y de comportamiento del botón
        b.setForeground(Color.WHITE);  // Establece el color del texto
        b.setDoubleBuffered(true);     // Habilita el doble buffer para una mejor visualización
        b.setOpaque(false);            // El botón no es opaco, dejando ver el fondo
        b.setFocusPainted(false);      // No se pinta el borde cuando se enfoca
        b.setContentAreaFilled(false); // No se llena el área de contenido con un color
        b.setIconTextGap(5);           // Establece el espacio entre el texto y el ícono
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Cambia el cursor a una mano cuando pasa sobre el botón

        // Calcula el ancho y la altura del botón en función del texto
        String text = b.getText();
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + (5);
        this.height = 48;  // Establece una altura fija para el botón
    }

    /**
     * Devuelve el tamaño preferido del botón.
     *
     * @param c El componente JComponent para el que se calcula el tamaño.
     * @return El tamaño preferido para el botón.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {
        dwidth = Math.max(width + 45, 84);  // Asegura que el ancho sea al menos 84 píxeles
        return new Dimension(Math.max(width, 84), 48);  // Establece el tamaño preferido del botón
    }

    /**
     * Devuelve el tamaño máximo del botón, igual que el tamaño preferido.
     *
     * @param c El componente JComponent para el que se calcula el tamaño.
     * @return El tamaño máximo para el botón.
     */
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Devuelve el tamaño mínimo del botón, igual que el tamaño preferido.
     *
     * @param c El componente JComponent para el que se calcula el tamaño.
     * @return El tamaño mínimo para el botón.
     */
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Inicializa las imágenes que se usan para los diferentes estados del botón (normal y hover).
     * En este caso, se cargan imágenes desde la caché.
     */
    private void initParts() {
        // Inicializa los arreglos de imágenes para los estados normal y hover
        parts = new ImageIcon[3];
        partsHover = new ImageIcon[3];

        // Agrega las imágenes al caché para su posterior uso
        ImageCache.addImage("userLeftSide", "Buttons/Boton.png");

        // Obtiene las imágenes de la caché y las almacena en los arreglos correspondientes
        parts[0] = ImageCache.getImageIcon("userLeftSide");
        partsHover[0] = ImageCache.getImageIcon("userLeftSide");
    }

    /**
     * Dibuja el botón en el componente gráfico.
     * Dependiendo del estado del botón (hover o no), se usan diferentes imágenes.
     *
     * @param g El objeto Graphics para pintar el botón.
     * @param c El componente JComponent (el botón) sobre el que se pinta.
     */
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);  // Llama al método base para pintar el componente
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;

        // Configura la calidad de las imágenes para que se dibujen con anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Se seleccionan las imágenes según el estado del botón (hover o normal)
        ImageIcon[] images = button.getModel().isRollover() ? partsHover : parts;

        // Dibuja las partes del botón usando las imágenes correspondientes
        drawButtonParts(g2d, images);

        // Establece el color para el texto
        g2d.setColor(Color.WHITE);

        // Llama al método base para dibujar el texto del botón
        super.paint(g2d, c);
    }

    /**
     * Dibuja las partes del botón usando las imágenes proporcionadas.
     *
     * @param g2d El objeto Graphics2D para pintar las imágenes.
     * @param parts El arreglo de imágenes que se dibujarán en el botón.
     */
    private void drawButtonParts(Graphics2D g2d, ImageIcon[] parts) {
        // Dibuja la imagen principal en el botón, escalándola según las dimensiones
        g2d.drawImage(parts[0].getImage(), 0, 0, dwidth, height, null);
    }
}
