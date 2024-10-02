public class Rex extends Enemy {
    public Rex() {
        super("Rex", 100, 40, 20,"Un dinosaurio rápido y mortal con garras afiladas.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " lanza un poderoso mordisco!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
    }
}

