import javax.swing.*;
import java.util.List;

public class Game {
    private Player player;
    private List<Enemy> enemies;

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
