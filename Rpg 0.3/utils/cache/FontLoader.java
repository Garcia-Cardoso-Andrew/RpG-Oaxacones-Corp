package utils.cache;
// Define el paquete donde se encuentra la clase FontLoader, en el subpaquete "utils.cache" dentro del proyecto RPG.

import javax.swing.*;
// Importa las clases de la biblioteca Swing, específicamente JOptionPane, utilizada para mostrar cuadros de diálogo.

import java.awt.*;
// Importa la clase Font de AWT (Abstract Window Toolkit), utilizada para trabajar con fuentes tipográficas.

import java.io.File;
// Importa la clase File, que se usa para trabajar con archivos y directorios en el sistema de archivos.

import java.io.FileInputStream;
// Importa FileInputStream, que se utiliza para leer archivos byte por byte, en este caso, para leer el archivo de la fuente.

import java.io.IOException;
// Importa IOException, que maneja errores de entrada/salida relacionados con la lectura del archivo.

import java.io.InputStream;
// Importa InputStream, que es la clase base para leer datos desde un archivo, utilizado por FileInputStream.

/**
 * Clase FontLoader que se encarga de cargar fuentes tipográficas desde archivos externos.
 * Si la fuente no se encuentra o hay un error al cargarla, se devuelve una fuente predeterminada (Arial).
 */
public class FontLoader {

    /**
     * Método para cargar una fuente tipográfica desde un archivo.
     * @param path Ruta del archivo de la fuente.
     * @return La fuente cargada o la fuente predeterminada en caso de error.
     */
    public static Font loadFont(String path) {
        // Método estático que carga una fuente desde el archivo especificado por `path`.

        File fontFile = new File(path);
        // Crea un objeto File con la ruta del archivo de la fuente.

        if (!fontFile.exists()) {
            // Si el archivo de la fuente no existe en la ruta especificada...
            JOptionPane.showMessageDialog(null, "La fuente no se encontró en la ruta: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            // Muestra un cuadro de diálogo de error indicando que la fuente no se encontró en la ruta dada.
            return new Font("Arial", Font.PLAIN, 12); // Retorna la fuente Arial como predeterminada en caso de error.
        }

        try (InputStream is = new FileInputStream(fontFile)) {
            // Intenta abrir un flujo de entrada para leer el archivo de la fuente.
            // El uso de "try-with-resources" asegura que el flujo se cierre automáticamente al finalizar.

            return Font.createFont(Font.TRUETYPE_FONT, is);
            // Crea un objeto Font a partir del archivo de fuente en formato TrueType (TTF) usando el flujo de entrada.
        } catch (FontFormatException | IOException e) {
            // Si ocurre un error al leer el archivo o si el archivo no tiene el formato correcto...
            JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
            // Muestra un cuadro de diálogo de error indicando que hubo un problema al cargar la fuente.
            return new Font("Arial", Font.PLAIN, 12); // Retorna la fuente Arial como predeterminada en caso de error.
        }
    }
}