package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public void createFile(String content) {
        try (BufferedWriter writer = new BufferedWriter ( new FileWriter ( filename ) )) {
            writer.write ( content );
            System.out.println ( "Archivo \"" + filename + "\" creado." );
        } catch (IOException e) {
            System.err.println ( "Error al crear el archivo: " + e.getMessage () );
        }
    }

    public String readFile() {
        File file = new File ( filename );
        if (!file.exists ()) {
            System.out.println ( "El archivo \"" + filename + "\" no existe." );
            return null;
        }

        StringBuilder content = new StringBuilder ();
        try (BufferedReader reader = new BufferedReader ( new FileReader ( file ) )) {
            String line;
            while ((line = reader.readLine ()) != null) {
                content.append ( line ).append ( "\n" );
            }
        } catch (IOException e) {
            System.err.println ( "Error al leer el archivo: " + e.getMessage () );
        }
        return content.toString ();
    }

    public void appendToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter ( new FileWriter ( filename, true ) )) {
            writer.write ( content );
            System.out.println ( "Contenido agregado al archivo \"" + filename + "\"." );
        } catch (IOException e) {
            System.err.println ( "Error al agregar contenido al archivo: " + e.getMessage () );
        }
    }

    public void deleteFile() {
        File file = new File ( filename );
        if (file.exists ()) {
            if (file.delete ()) {
                System.out.println ( "Archivo \"" + filename + "\" eliminado." );
            } else {
                System.err.println ( "Error al eliminar el archivo." );
            }
        } else {
            System.out.println ( "El archivo \"" + filename + "\" no existe." );
        }
    }



    }
