package rpg.entities;

public class Game {
    private Player player;
    private Enemy enemy;

    /* Constructor que inicializa los objetos Player y Enemy */
    public Game(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // Método para iniciar el juego
    public void startGame() {
        System.out.println("¡El juego ha comenzado!");

        // Mostrar los nombres de los participantes
        System.out.println(player.getName() + " vs " + enemy.getName());

        // Ciclo que continúa hasta que uno de los dos pierda todos los puntos de vida
        while (player.getStat(Stats.HP) > 0 && enemy.getStat(Stats.HP) > 0) {
            // Turno del jugador
            System.out.println("\nTurno de " + player.getName());
            player.attack(enemy);
            if (enemy.getStat(Stats.HP) <= 0) {
                System.out.println(enemy.getName() + " ha sido derrotado.");
                break;
            }

            // Turno del enemigo
            System.out.println("\nTurno de " + enemy.getName());
            enemy.attack(player);
            if (player.getStat(Stats.HP) <= 0) {
                System.out.println(player.getName() + " ha sido derrotado.");
                break;
            }
        }

        // Mostrar el resultado final
        if (player.getStat(Stats.HP) > 0) {
            System.out.println("\n¡" + player.getName() + " ha ganado el juego!");
        } else {
            System.out.println("\n¡" + enemy.getName() + " ha ganado el juego!");
        }
    }
}
