package rpg.entities.enemies;

import rpg.entities.GameCharacter;
import rpg.entities.Player;
import javax.swing.*;


public abstract class Enemy extends GameCharacter {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int Defense;
    protected String description;

    public Enemy(String name, int health, int attackPower,int Defense ,String description) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.description = description;
        this.Defense = Defense;
    }

    public abstract void attack(Player player) ;



    /* Método para recibir daño */
    public void takeDamage(int damage) {
        if (Defense > 0) {
            // Reducir defensa primero
            int remainingDamage = damage - Defense;
            if (remainingDamage < 0) {
                remainingDamage = 0; // Evitar daño negativo
            }
            Defense -= damage;
            if (Defense < 0) {
                Defense = 0; // Evitar defensa negativa
            }

            // Mostrar la reducción de defensa
            JOptionPane.showMessageDialog(null, name + " ha recibido " + damage + " de daño. Defensa restante: " + Defense);

            // Si queda daño restante después de reducir la defensa, aplicarlo a la salud
            if (remainingDamage > 0) {
                applyDamageToHealth(remainingDamage);
            }

        } else {
            // Si no queda defensa, todo el daño va a la salud
            applyDamageToHealth(damage);
        }
    }
    /* Método para aplicar daño a la salud */
    private void applyDamageToHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Evitar salud negativa
        }
        JOptionPane.showMessageDialog(null, name + " ha recibido " + damage + " de daño. Salud restante: " + health);
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + name + "\nSalud: " + health + "\nPoder de ataque: " + attackPower + "\nDescripción: " + description);
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Método getter para el nombre
    public String getName() {
        return name;
    }

    // Método getter para el poder de ataque
    public int getAttackPower() {
        return attackPower;
    }
    /* Método getter para la defensa */
    public int getDefense() {
        return Defense;
    }
    /* Método setter para la defensa */
    public void setDefense(int Defense) {
        this.Defense = Defense;
    }
}
