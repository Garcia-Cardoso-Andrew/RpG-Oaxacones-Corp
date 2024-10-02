import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import rpg.entities.Player;
import rpg.entities.enemies.*;
import rpg.entities.enemies.raptor.Raptor;
import rpg.entities.enemies.rex.Rex;
import rpg.entities.enemies.therizino.Therizino;

public class Main {
    public static void main(String[] args) {
        // Crear un jugador
        String playerName = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. El juego se cerrará.");
            System.exit(0);
        }

        Player player = new Player(playerName, 100, 30, 50

        ); // Nombre, salud, poder de ataque

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Raptor ());      // Instancia de la subclase Raptor
        enemies.add(new Rex ());         // Instancia de la subclase Rex
        enemies.add(new Therizino ());   // Instancia de la subclase Therizino

        // Inicializar el juego
        Game game = new Game(player);

        // Iniciar el juego
        game.startGame();
    }
}
