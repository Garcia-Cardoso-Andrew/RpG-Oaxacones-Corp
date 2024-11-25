/*
   Esta clase es el punto de entrada principal del juego. 
   Configura el entorno gráfico, solicita el nombre del jugador y lanza el juego.
*/
package entities.Game;
import entities.Player.Player;

import javax.swing.*;
import java.awt.*;
public class GameLauncher {
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
        Player player = new Player(playerName, 100, 30,50);

        // Inicializar el juego con el jugador
        Game game = new Game(player);

        // Iniciar el juego
        game.startGame();
    }
}

