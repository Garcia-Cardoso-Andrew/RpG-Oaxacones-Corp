/*
   Esta clase representa un enemigo específico en el juego, el Carnotaurus.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Carnotaurus.
*/


public class Carnotaurus extends Enemy {
    public Carnotaurus() {
        super("Carnotaurus", 150, 50, 25,"Un depredador con cuernos, fuerte y ágil.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " te embosca con fuerza!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
    }
}

