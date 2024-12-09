package gui.windows;
import entities.Player.Player;
import entities.enemy.Enemy;
import enums.BarType;
import enums.Stats;
import factory.EnemyFactory;
import gui.buttons.*;
import gui.labels.*;
import gui.panels.BottomPanel;
import gui.panels.MiddlePanel;
import gui.panels.TopPanel;
import gui.ui.HexagonosLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * MainWindow es la ventana principal del juego RPG, que contiene la interfaz gráfica de usuario (UI) y la lógica del juego.
 * Controla la interacción entre el jugador, el enemigo y los componentes de la UI como las barras de vida, botones, y texto.
 */

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JDesktopPane desktopPane;
    private JButton button1;
    private JButton Atacar;
    private JButton Huir;
    private JButton Skills;
    private JLabel portraitLabel;
    private JButton button2;
    private JButton button3;
    private JLabel LifeLabel;
    private JLabel MagicLabel;
    private JLabel ExpLabel;
    private JLabel nameLabel;
    private JLabel goldLabel;
    private JScrollPane textScroll;
    private JTextArea textDisplay;
    private JLabel playerSprite;
    private JLabel enemyNameLabel;
    private JLabel enemyLifeLabel;
    private JLabel enemySprite;
    private JButton button4;

    private Player player;
    private Enemy enemy;
    private int slot;

    /**
     * Constructor de MainWindow. Inicializa la ventana principal con el jugador y el slot proporcionados.
     */
    public MainWindow(Player player, int slot) {
        this.player = player;
        this.slot = slot;

        // Inicializa al enemigo antes de llamar a createUIComponents()
        createEnemy();

        // Ahora se inicializan los componentes de la UI
        initComponents();

        ((BarLabel) LifeLabel).updateBar(player.getStats().get(Stats.HP), player.getStats().get(Stats.MAX_HP));
        ((BarLabel) MagicLabel).updateBar(player.getStats().get(Stats.MP), player.getStats().get(Stats.MAX_MP));
        ((BarLabel) ExpLabel).updateBar(player.getStats().get(Stats.EXPERIENCE), player.getStats().get(Stats.NEEDED_EXPERIENCE));

        appendText("¡Bienvenido a RPG Game!\n");
        appendText("¡Prepárate para la aventura!\n");
        appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
    }

    /**
     * Inicializa todos los componentes de la ventana principal.
     */
    private void initComponents() {
        desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(mainPanel != null ? mainPanel.getPreferredSize() : null);
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        setContentPane(desktopPane);

        setTitle("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        textScroll.getViewport().setOpaque(false);
        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(WindowConstants.DEFAULT_FONT.deriveFont(22f));
        textDisplay.setBorder(new EmptyBorder(10, 10, 10, 10));
        textDisplay.setForeground(Color.BLACK);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
    }

    /**
     * Añade texto al área de texto de la UI.
     */
    public void appendText(String text) {
        textDisplay.append(text);
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    /**
     * Crea los componentes de la interfaz de usuario, como paneles, botones y etiquetas.
     */
    private void createUIComponents() {
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();

        button1 = new SaveButton(this, player, slot);
        button2 = new BaseButton("Inventario");
        button3 = new BaseButton("Tienda");
        button4 = new ExitButton();

        Atacar = new AttackButton(this);
        Huir = new FleeButton(this);
        Skills = new BaseButton("Skills");

        portraitLabel = new PortraitLabel();

        LifeLabel = new BarLabel(100, 100, BarType.LIFE);
        MagicLabel = new BarLabel(30, 100, BarType.MAGIC);
        ExpLabel = new BarLabel(100, 100, BarType.EXPERIENCE);

        goldLabel = new HexagonosLabel();
        nameLabel = new NameLabel("Andrew LVL. 1");

        playerSprite = new PlayerSpriteLabel();
        enemyNameLabel = new NameLabel(enemy.getName());
        enemyLifeLabel = new BarLabel(100, 100, BarType.LIFE);
        enemySprite = new EnemySpriteLabel(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    /**
     * Verifica el estado del juego y determina si el jugador o el enemigo han muerto.
     */
    public void checkGameStatus() {
        if (!player.isAlive()) {
            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {
            int playerExp = player.getStats().get(Stats.EXPERIENCE);
            int enemyExp = enemy.getStats().get(Stats.EXPERIENCE);
            int promotionExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
            int playerGold = player.getStats().get(Stats.GOLD);
            int enemyGold = enemy.getStats().get(Stats.GOLD);

            int totalExp = playerExp + enemyExp;
            int totalGold = playerGold + enemyGold;
            appendText(""" 
                    Has derrotado a %s
                    Has ganado %d puntos de experiencia.
                    Has ganado %d monedas de oro.
                    """.formatted(enemy.getName(), enemyExp, enemyGold));

            player.getStats().put(Stats.EXPERIENCE, totalExp);
            player.getStats().put(Stats.GOLD, totalGold);
            goldLabel.setText(totalGold + "G");
            goldLabel.repaint();

            if (totalExp >= promotionExp) {
                updatePlayer();
            }
            createEnemy();
        }
        updateBars();
    }

    /**
     * Actualiza el nivel y las barras de estado del jugador.
     */
    private void updatePlayer() {
        player.levelUp();
        int level = player.getStats().get(Stats.LEVEL);
        int hp = player.getStats().get(Stats.HP);
        int mp = player.getStats().get(Stats.MP);
        int neededExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);

        appendText("Has subido de nivel.\n");
        ((BarLabel) LifeLabel).updateBar(hp, hp);
        ((BarLabel) MagicLabel).updateBar(mp, mp);
        ((BarLabel) ExpLabel).updateBar(0, neededExp);

        ((NameLabel) nameLabel).updateLabel("%s LVL. %d".formatted(player.getName(), level));
    }

    /**
     * Crea un nuevo enemigo para el combate.
     */
    private void createEnemy() {
        enemy = EnemyFactory.getEnemy();  // Asume que EnemyFactory maneja la creación del enemigo
        if (enemy != null) {
            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());
            ((BarLabel) enemyLifeLabel).updateBar(enemy.getStats().get(Stats.HP), enemy.getStats().get(Stats.MAX_HP));
        }
    }

    /**
     * Actualiza las barras de vida y experiencia del jugador y el enemigo.
     */
    private void updateBars() {
        ((BarLabel) LifeLabel).setBarValue(player.getStats().get(Stats.HP));
        ((BarLabel) ExpLabel).setBarValue(player.getStats().get(Stats.EXPERIENCE));
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

    /**
     * Intenta que el jugador huya del combate.
     */
    public void tryToFlee() {
        if (player.tryToFlee()) {
            appendText("Has huido con éxito, tío.\n");
            createEnemy();
        } else {
            appendText("No has podido huir.\n");
            appendText(enemy.attack(player));
        }
        updateBars();
    }
}
