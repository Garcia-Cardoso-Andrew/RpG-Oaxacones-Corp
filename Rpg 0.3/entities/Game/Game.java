package entities.Game;

import entities.enemy.Enemy;
import entities.enemy.Enemys.*;

import gui.windows.GUIForm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import entities.Player.Player;


/**
 * Esta clase representa el flujo principal del juego en el que el jugador lucha contra varios enemigos.
 * Proporciona la lógica para gestionar los turnos del jugador y los enemigos, así como el inicio y final del juego.
 */
public class Game {
    private final Player player;
    private final List<Enemy> enemies;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();

        // Añadir los enemigos al juego
        enemies.add(new Raptor());
        enemies.add(new Rex());
        enemies.add(new Therizino());
        enemies.add(new Spinosaurus());
        enemies.add(new Carnotaurus());

    }

    public void startGame() {
        System.out.println("¡El juego ha comenzado!");

        for (Enemy enemy : enemies) {
            enemy.displayInfo();

            while (player.isAlive() && enemy.isAlive()) {
                playerTurn(enemy);
                if (!enemy.isAlive()) {
                    showMessage(enemy.getName() + " ha sido derrotado!");
                    break;
                }
                enemyTurn(enemy);
            }

            if (!player.isAlive()) {
                showMessage(player.getName() + " ha sido derrotado!");
                break;
            }
        }

        if (player.isAlive()) {
            showMessage("¡Has derrotado a todos los enemigos!");
        } else {
            showMessage("¡Has perdido el juego!");
        }
    }

    private void playerTurn(Enemy enemy) {
        String[] options = {"Atacar", "Ver estadísticas"};

        int choice = JOptionPane.showOptionDialog(null,
                "Es tu turno. ¿Qué deseas hacer?",
                "Turno del Jugador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) { // Atacar
            player.attack(enemy);
            if (!enemy.isAlive()) {
                showMessage(enemy.getName() + " ha sido derrotado!");
            }
        } else if (choice == 1) { // Ver estadísticas
            player.displayInfo();
            enemy.displayInfo();
        }
    }

    private void enemyTurn(Enemy enemy) {
        enemy.attack(player);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        // Crear una instancia de GUIForm para mostrar la ventana principal
        SwingUtilities.invokeLater(GUIForm::new);
    }
}