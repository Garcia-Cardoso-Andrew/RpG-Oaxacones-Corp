public class Raptor extends Enemy {
    public Raptor() {
        super("Raptor", 50, 20,5 ,"Un dinosaurio rápido y mortal con garras afiladas."); // Defensa ligera
    }

    @Override
    public void attack(Player player) {
        System.out.println(getName() + " ataca con ferocidad!");
        player.takeDamage(attackPower);
    }
}


