package utils.cache;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase ImageCache que administra un caché de imágenes para evitar cargas repetidas desde el disco.
 * Utiliza un mapa para almacenar las imágenes cargadas por nombre y ruta.
 */
public class ImageCache {

    // Definición de la ruta base donde se encuentran las imágenes.
    private static final String IMAGE_PATH = "Imagenes/";  // Ruta base para las imágenes

    // Mapa estático para almacenar las imágenes cargadas.
    private static final Map<String, BufferedImage> CACHE = new HashMap<>();

    /**
     * Método para agregar una imagen al caché.
     * @param name Nombre clave para la imagen.
     * @param path Ruta relativa de la imagen a cargar.
     * @return La imagen cargada desde el archivo.
     */
    public static BufferedImage addImage(String name, String path) {
        BufferedImage image;

        if (!CACHE.containsKey(name)) {
            // Si la imagen no está en el caché, se carga desde el disco.
            image = ImageLoader.loadImage(IMAGE_PATH + path);

            if (image != null) {
                CACHE.put(name, image);  // Solo la agrega si se cargó correctamente.
            } else {
                System.err.println("Error: No se pudo cargar la imagen desde la ruta: " + IMAGE_PATH + path);
                return null;  // Si la imagen no se carga, devuelve null.
            }
        } else {
            // Si la imagen ya está en el caché, se recupera.
            image = CACHE.get(name);
        }
        return image;
    }

    /**
     * Método para obtener una imagen desde el caché.
     * @param imageName Nombre de la imagen que se desea obtener.
     * @return La imagen solicitada o null si no está en el caché.
     */
    public static BufferedImage getImage(String imageName) {
        return CACHE.getOrDefault(imageName, null);  // Devuelve la imagen o null si no existe.
    }

    /**
     * Método para obtener un ImageIcon desde el caché.
     * @param imageName Nombre de la imagen que se desea obtener.
     * @return Un ImageIcon creado a partir de la imagen del caché.
     */
    public static ImageIcon getImageIcon(String imageName) {
        BufferedImage image = getImage(imageName);
        if (image != null) {
            return new ImageIcon(image);
        } else {
            System.err.println("Error: La imagen no está disponible en el caché.");
            return null;  // Devuelve null si la imagen no existe en el caché.
        }
    }
}


