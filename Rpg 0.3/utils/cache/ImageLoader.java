package utils.cache;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase ImageLoader para cargar imágenes desde archivos utilizando ImageIO.
 * Proporciona un método para leer imágenes desde un archivo en el sistema.
 */
public class ImageLoader {

    /**
     * Método estático para cargar una imagen desde una ruta especificada.
     * @param path Ruta al archivo de la imagen.
     * @return La imagen cargada como un objeto BufferedImage, o null si ocurre un error.
     */
    public static BufferedImage loadImage(String path) {
        try {
            // Intentamos cargar la imagen utilizando ImageIO.
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            // Si ocurre un error (por ejemplo, si la imagen no existe o no se puede leer), mostramos un error.
            JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;  // Devuelve null si no se pudo cargar la imagen.
        }
    }
}

