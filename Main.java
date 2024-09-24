import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear un jugador
        String playerName = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        Player player = new Player(playerName, 100, 30); // Nombre, salud, poder de ataque

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Raptor", "Raptor"));
        enemies.add(new Enemy("Rex", "Rex"));
        enemies.add(new Enemy("Therizino", "Therizino"));

        // Inicializar el juego
        Game game = new Game(player, enemies);

        // Iniciar el juego
        game.startGame();
    }
}
