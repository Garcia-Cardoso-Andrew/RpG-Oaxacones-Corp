import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
package rpg.entities.enemies;

import rpg.entities.Player;

/* Clase Game que representa la interfaz de el juego */
/* Gestiona el tiempo y estadisticas de el juego, junto con los enemigos y el jugador */
public class Game {
    private Player player;
    private List<Enemy> enemies;

    //Construcción del Juego
    
    /* Constructor que inicializa el jugador y una lista de enemigos */
    public Game(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    /* Método para iniciar el juego */
    public void startGame() {
        JOptionPane.showMessageDialog(null, "¡El juego ha comenzado!\nJugador: " + player.getName() + "\n");

        for (Enemy enemy : enemies) {
            JOptionPane.showMessageDialog(null, "¡Un " + enemy.getType() + " aparece!\n" + enemy.getName());

            // Ciclo de combate contra cada enemigo
            while (player.isAlive() && enemy.isAlive()) {
                playerTurn(enemy);
                if (!enemy.isAlive()) {
                    JOptionPane.showMessageDialog(null, enemy.getName() + " ha sido derrotado.");
                    break;
                }
                enemyTurn(enemy);
            }

            if (!player.isAlive()) {
                JOptionPane.showMessageDialog(null, player.getName() + " ha sido derrotado.");
                break;
            }
        }

        // Mostrar el resultado final
        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha derrotado a todos los enemigos!");
        } else {
            JOptionPane.showMessageDialog(null, "¡Has perdido el juego!");
        }
    }

    /* Lógica del turno del jugador */
    private void playerTurn(Enemy enemy) {
        String[] options = {"Atacar", "Mostrar estado"};
        int choice = JOptionPane.showOptionDialog(null, "Turno de " + player.getName(),
                "Selecciona una opción", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            player.attack(enemy);
        } else if (choice == 1) {
            player.displayInfo();
        } else {
            JOptionPane.showMessageDialog(null, "Opción no válida, pierdes tu turno.");
        }
    }

    /* Lógica del turno del enemigo */
    private void enemyTurn(Enemy enemy) {
        JOptionPane.showMessageDialog(null, "Turno de " + enemy.getName());
        enemy.attack(player);
    }
}
/* parte de prueba y funcionalidad de game */
class GameLauncher {

    public static void main(String[] args) {
        // Configurar la fuente a Times New Roman para todas las ventanas emergentes
        UIManager.put("OptionPane.messageFont", new Font("Times New Roman", Font.PLAIN, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Times New Roman", Font.PLAIN, 14));

        // Crear un jugador usando una ventana emergente para obtener el nombre
        String playerName = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. El juego se cerrará.");
            System.exit(0);
        }

        // Crear el jugador con nombre, salud inicial de 100 y poder de ataque de 30
        Player player = new Player(playerName, 100, 30);

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Raptor", "Raptor"));
        enemies.add(new Enemy("Rex", "Rex"));
        enemies.add(new Enemy("Therizino", "Therizino"));

        // Inicializar el juego con el jugador y la lista de enemigos
        Game game = new Game(player, enemies);

        // Iniciar el juego
        game.startGame();
    }
}
