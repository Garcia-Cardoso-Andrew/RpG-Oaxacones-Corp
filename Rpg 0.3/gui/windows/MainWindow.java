package gui.windows;

import entities.Player.Player;
import entities.enemy.Enemy;
import factory.EnemyFactory;
import enums.BarType;
import enums.Stats;
import gui.ui.HexagonosLabel;
import gui.ui.UIConstants;
import gui.buttons.*;
import gui.internalFrames.InventoryFrame;
import gui.internalFrames.StatusFrame;
import gui.labels.*;
import gui.panels.BottomPanel;
import gui.panels.MessagePanel;
import gui.panels.MiddlePanel;
import gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private TopPanel topPanel;
    private MiddlePanel middlePanel;
    private BottomPanel bottomPanel;
    private JButton blacksmithButton;
    private JButton shopButton;
    private JButton inventoryButton;
    private JLabel exampleLabel;
    private JButton atacarButton;
    private JButton habilidadesButton;
    private JButton huirButton;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JLabel lifeLabel;
    private JLabel magicLabel;
    private JLabel expLabel;
    private JLabel nameLabel;
    private JLabel goldLabel;
    private JButton exitButton;
    private JButton saveButton;
    private JLabel playerSprite;
    private JLabel enemySprite;
    private JLabel enemyLifeLabel;
    private JLabel enemyNameLabel;
    private JPanel messagePanel;
    private JPanel enemyPanel;
    private JDesktopPane desktopPane;
    private final JInternalFrame statusFrame;
    private final JInternalFrame inventoryFrame;
    Player player;
    Enemy enemy;
    int slot;

    public MainWindow(Player player, int slot) {

        this.player = player;
        this.slot = slot;
        initComponents();
        statusFrame = new StatusFrame(this);
        inventoryFrame = new InventoryFrame(this);
        desktopPane.add(statusFrame, JLayeredPane.PALETTE_LAYER);
        desktopPane.add(inventoryFrame, JLayeredPane.PALETTE_LAYER);
        // Colocamos los InternalFrames en la posición deseada
        statusFrame.setLocation((desktopPane.getWidth() - statusFrame.getWidth()) / 2,
                (desktopPane.getHeight() - statusFrame.getHeight()) / 2);
        inventoryFrame.setLocation((desktopPane.getWidth() - inventoryFrame.getWidth()) / 2,
                (desktopPane.getHeight() - inventoryFrame.getHeight()) / 2);
        // Añadimos un mensaje al textDisplay de bienvenida
        appendText("¡Bienvenido a RPG Game!\n");
        appendText("¡Prepárate para la aventura!\n");
        appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
    }

    private void initComponents() {
        // Creamos un DesktopPane para poder agregar los componentes
        desktopPane = new JDesktopPane();
        // Hacemos que el tamaño del DesktopPane sea igual al
        // tamaño del panel principal
        desktopPane.setPreferredSize(mainPanel != null ?
                mainPanel.getPreferredSize() : null);
        // Definimos los Bounds del panel principal
        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width,
                mainPanel.getPreferredSize().height);
        // Agregamos el panel principal al DesktopPane
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        // Agregamos el panel principal a la ventana
        setContentPane(desktopPane);
        // Definimos el título de la ventana
        setTitle("RPG Game");
        // Definimos la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Tomamos el tamaño de los componentes
        pack();
        // Centramos la ventana
        setLocationRelativeTo(null);
        // Hacemos visible la ventana
        setVisible(true);
        // Definimos que la ventana no se pueda redimensionar
        setResizable(false);
        // Definimos la forma de trabajo del ScrollPane
        // Hacemos que el ScrollPane no tenga bordes y sea transparente
        textScroll.getViewport().setOpaque(false);
        textScroll.setBorder(null);
        // Hacemos que el ScrollPane tenga solo la barra vertical
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Definimos el color de fondo del display en Blanco y su fuente en 28px
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setForeground(Color.WHITE);
        // Configuramos el scrool del textDisplay
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        goldLabel.setText(player.getStats().get() + "G");
    }

    /**
     * Esta función permite añadir texto al textDisplay.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde otras clases.
     */
    public void appendText(String text) {

        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se posicione en la última línea
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    /**
     * Esta función permite intentar huir de un combate.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde la clase FleeButton.
     */
    public void tryToFlee() {

        // Si el jugador logra huir
        if (player.tryToFlee()) {
            // Añadimos un mensaje al textDisplay de que se logró huir
            appendText("Has huido con éxito.\n");
            // Creamos un nuevo enemigo
            createEnemy();
        } else {
            // Añadimos un mensaje al textDisplay de que no se pudo huir
            appendText("No has podido huir.\n");
            // El enemigo ataca al jugador
            appendText(enemy.attack(player));
        }
        // Actualizamos las barras status del jugador y del enemigo
        updateBars();
    }

    /**
     * Esta función permite verificar el estado del juego y actualizar las barras de estado.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde la clase AttackButton.
     */
    public void checkGameStatus() {

        // Verificamos si el jugador o el enemigo han muerto
        if (!player.isAlive()) {
            // En caso de que el jugador haya muerto
            // Añadimos un mensaje al textDisplay de que el jugador ha muerto
            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {
            // En caso de que el enemigo haya muerto
            // Recuperamos la experiencia y el oro del jugador y del enemigo
            int playerExp = (int) player.getStats().get();
            int enemyExp = enemy.getStats().get(Stats.EXPERIENCE);

            // Calculamos el total de experiencia y oro
            int totalExp = playerExp + enemyExp;
            // Añadimos un mensaje al textDisplay de que se ha derrotado al enemigo
            // y se ha ganado experiencia y oro.
            appendText("""
                    Has derrotado a %s
                    Has ganado %d puntos de experiencia.
                    Has ganado %d monedas de oro.
                    """.formatted(enemy.getName(), enemyExp));
            // Asignamos la nueva experiencia y oro al jugador

            // Evaluamos si el jugador ha subido de nivel

            // Creamos un nuevo enemigo en cualquier caso
            createEnemy();
        }
        updateBars();
    }

    private void createEnemy() {

        enemy = EnemyFactory.getEnemy();
        if (enemy != null) {

            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());

        }
    }

    private void updateBars() {

        ((BarLabel) lifeLabel).setBarValue( (Integer) player.getStats().get() );
        ((BarLabel) expLabel).setBarValue( (Integer) player.getStats().get() );
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

    /**
     * Esta función permite actualizar al jugador cuando sube de nivel.
     * <p>
     * **IMPORTANTE**: Esta función se llama desde la función checkGameStatus.
     */


    /**
     * Esta función permite personalizar los componentes de la ventana.
     * Como por ejemplo usar clases propias que extiendan de JPanel u otros componentes.
     * <p>
     * **IMPORTANTE**: Si marcamos algún componente en el editor de diseño como
     * "Custom Create", deberemos que especificar como se creara en esta función.
     */
    private void createUIComponents() {

        enemy = EnemyFactory.getEnemy();
        messagePanel = new MessagePanel();
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        exitButton = new ExitButton();
        atacarButton = new AttackButton(this);
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton(this);
        exampleLabel = new PortraitLabel();
        lifeLabel = new BarLabel(0, 0, BarType.LIFE);
        magicLabel = new BarLabel(0, 0, BarType.MAGIC);
        expLabel = new BarLabel(0, 0, BarType.EXPERIENCE);
        nameLabel = new NameLabel(String.format("%s LVL. %d", player.getName(),
                player.getStats().get()));
        playerSprite = new PlayerSpriteLabel();
        enemyNameLabel = new NameLabel(enemy.getName());

        enemySprite = new EnemySpriteLabel(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public JInternalFrame getInventoryFrame() {
        return inventoryFrame;
    }

    public JInternalFrame getStatusFrame() {
        return statusFrame;
    }
}
