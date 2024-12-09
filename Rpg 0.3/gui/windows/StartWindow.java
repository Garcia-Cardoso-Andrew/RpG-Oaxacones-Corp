package gui.windows;

import entities.Player.Player;
import enums.Stats;
import gui.buttons.LoadFileButton;
import gui.buttons.NewFileButton;
import gui.labels.NameLabel;
import gui.panels.FilesPanel;
import gui.ui.NameLabelUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

// Clase principal que representa la ventana de inicio del juego.
public class StartWindow extends JFrame {
    // Declaración de los componentes gráficos de la interfaz.
    private JPanel mainPanel;
    private JButton newFile1;
    private JButton loadFile1;
    private JLabel titleLabel;
    private JLabel file1Name;
    private JLabel file2Name;
    private JLabel file3Name;
    private JLabel file4Name;
    private JLabel file5Name;
    private JButton newFile2;
    private JButton newFile3;
    private JButton newFile4;
    private JButton newFile5;
    private JButton loadFile2;
    private JButton loadFile3;
    private JButton loadFile4;
    private JButton loadFile5;

    // Método principal que inicia la ventana de inicio.
    public static void main(String[] args) {
        new StartWindow();
    }

    // Constructor que configura la ventana inicial del juego.
    public StartWindow() {
        // Configuración de la ventana.
        this.setContentPane(mainPanel); // Establece el panel principal.
        this.setTitle("Java RPG"); // Título de la ventana.
        this.setSize(WindowConstants.START_WINDOW_DIMENSION); // Tamaño de la ventana.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Comportamiento al cerrar la ventana.
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla.
        this.setResizable(false); // Impide que se cambie el tamaño de la ventana.
        this.setVisible(true); // Hace visible la ventana.
        update(); // Actualiza la información de los slots de guardado.
    }

    // Método que actualiza el contenido de los slots de guardado.
    public void update() {

        // Recorre los cinco slots de guardado (1 a 5).
        for (int i = 1; i <= 5; i++) {
            JLabel slotLabel = null; // Etiqueta que muestra el nombre de la partida.
            String slotName; // Nombre del jugador y nivel.
            Player player; // Objeto jugador.
            JButton newFileButton; // Botón para crear una nueva partida.
            JButton loadFileButton; // Botón para cargar una partida guardada.

            try {
                // Se obtiene la referencia a los componentes correspondientes a cada slot mediante reflexión.
                slotLabel = (JLabel) getClass().getDeclaredField("file" + i + "Name").get(this);
                newFileButton = (JButton) getClass().getDeclaredField("newFile" + i).get(this);
                loadFileButton = (JButton) getClass().getDeclaredField("loadFile" + i).get(this);

                // Verifica si el archivo de la partida está vacío.
                if (isFileEmpty(i)) {
                    // Si está vacío, muestra "Vació" en la etiqueta y habilita el botón de nueva partida.
                    slotLabel.setText("-- Vació --");
                    slotLabel.setUI(new NameLabelUI()); // Establece un estilo de UI para la etiqueta.
                    newFileButton.setVisible(true); // Hace visible el botón de nueva partida.
                    loadFileButton.setVisible(false); // Oculta el botón de cargar partida.
                    continue; // Pasa al siguiente slot.
                } else {
                    // Si no está vacío, habilita el botón de cargar partida.
                    newFileButton.setVisible(false);
                    loadFileButton.setVisible(true);
                    // Carga el jugador desde el archivo de guardado.
                    player = Player.load(i);
                }

                // Si el jugador es válido, muestra su nombre y nivel.
                if (player != null) {
                    slotName = String.format("%s - NIVEL: %d", player.getName().toUpperCase(), player.getStats().get(Stats.LEVEL));
                    slotLabel.setText(slotName);
                    slotLabel.setUI(new NameLabelUI());
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                // Si ocurre un error al obtener los componentes, muestra un mensaje de error.
                JOptionPane.showMessageDialog(null, "Error al cargar la partida " + i, "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // En caso de otro tipo de error, marca el slot como vacío.
                slotLabel.setText("-- Vació --");
                slotLabel.setUI(new NameLabelUI());
                try {
                    // Intenta ocultar el botón de cargar partida en caso de error.
                    loadFileButton = (JButton) getClass().getDeclaredField("loadFile" + i).get(this);
                    loadFileButton.setVisible(false);
                } catch (IllegalAccessException | NoSuchFieldException ex) {
                    ex.printStackTrace(); // Imprime el stack trace del error.
                }
            }
        }
    }

    // Método que inicializa los componentes de la interfaz gráfica.
    private void createUIComponents() {
        // Creación de los componentes gráficos para la interfaz.
        mainPanel = new FilesPanel(); // Panel que contiene los slots de guardado.
        titleLabel = new JLabel("Java RPG"); // Etiqueta de título.
        titleLabel.setForeground(Color.WHITE); // Establece el color del texto.
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Establece la fuente y tamaño del texto.
        file1Name = new NameLabel(""); // Etiqueta para mostrar el nombre de la primera partida.
        newFile1 = new NewFileButton(1, this); // Botón para crear una nueva partida en el primer slot.
        loadFile1 = new LoadFileButton(1, this); // Botón para cargar una partida en el primer slot.
        file2Name = new NameLabel(""); // Etiqueta para el segundo slot.
        newFile2 = new NewFileButton(2, this); // Botón para el segundo slot.
        loadFile2 = new LoadFileButton(2, this); // Botón para cargar en el segundo slot.
        file3Name = new NameLabel(""); // Etiqueta para el tercer slot.
        newFile3 = new NewFileButton(3, this); // Botón para el tercer slot.
        loadFile3 = new LoadFileButton(3, this); // Botón para cargar en el tercer slot.
        file4Name = new NameLabel(""); // Etiqueta para el cuarto slot.
        newFile4 = new NewFileButton(4, this); // Botón para el cuarto slot.
        loadFile4 = new LoadFileButton(4, this); // Botón para cargar en el cuarto slot.
        file5Name = new NameLabel(""); // Etiqueta para el quinto slot.
        newFile5 = new NewFileButton(5, this); // Botón para el quinto slot.
        loadFile5 = new LoadFileButton(5, this); // Botón para cargar en el quinto slot.
    }

    // Método que verifica si el archivo de un slot está vacío.
    private boolean isFileEmpty(int slot) {
        // Comprueba si el archivo de guardado existe en el directorio "files".
        return !new File("files/save" + slot + ".dat").exists();
    }
}
