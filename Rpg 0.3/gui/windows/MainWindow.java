package gui.windows;

import gui.labels.PortraitLabel;
import gui.windows.UIConstants;
import gui.buttons.*;
import gui.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements WindowConstants {
    private final JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private BaseButton button1;
    private BaseButton b2;
    private BaseButton b3;
    private AttackButton atacarButton;
    private SkillPanelButton habilidadesButton;
    private FleeButton huirButton;
    private PortraitLabel exampleLabel;

    public MainWindow() {
        // Establecer el título de la ventana
        setTitle("RPG Game");

        // Establecer el tamaño de la ventana usando constantes
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Establecer la operación de cierre predeterminada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar los paneles
        createUIComponents();

        // Configurar el layout del panel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Layout vertical

        // Agregar los paneles al panel principal
        mainPanel.add(topPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);

        // Establecer el contenido del panel
        setContentPane(mainPanel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void createUIComponents() {
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        button1 = new BaseButton(UIConstants.BUTTON_1_TEXT) {
            @Override
            protected void initIcons() {

            }
        };
        b2 = new BaseButton(UIConstants.TIENDAS_BUTTON_TEXT) {
            @Override
            protected void initIcons() {

            }
        };
        b3 = new BaseButton(UIConstants.INVENTARIO_BUTTON_TEXT) {
            @Override
            protected void initIcons() {

            }
        };
        atacarButton = new AttackButton();
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton();
        exampleLabel = new PortraitLabel();
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de despacho de eventos
        SwingUtilities.invokeLater(MainWindow::new);
    }
}