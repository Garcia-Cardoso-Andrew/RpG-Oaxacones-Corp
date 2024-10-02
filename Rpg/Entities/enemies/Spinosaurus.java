public class Spinosaurus extends Enemy {
    public Spinosaurus() {
        super("Spinosaurus", 110, 50, 15, "Un dinosaurio rápido y mortal con garras afiladas.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " ataca con su gran mandíbula!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
    }
}
