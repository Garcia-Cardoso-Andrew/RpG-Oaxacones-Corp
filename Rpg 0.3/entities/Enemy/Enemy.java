/* 
   Esta clase representa a un enemigo genérico del juego. 
   Proporciona propiedades como nombre, salud, poder de ataque, defensa y descripción.
   Define comportamientos como recibir daño, atacar y mostrar información del enemigo.
*/
package entities.Enemy;

import entities.GameCharacter;
import entities.Player.Player;

import javax.swing.*;

public abstract class Enemy extends GameCharacter {
    protected int health;
    protected int attackPower;
    protected int defense;
    protected String description;

    public Enemy(String name, int health, int attackPower, int defense, String description) {
        super(name); // Llama al constructor de GameCharacter
        this.health = health;
        this.attackPower = attackPower;
        this.description = description;
        this.defense = defense;
    }

    public abstract void attack(Player player);

    /* Método para recibir daño */
    @Override
    public void takeDamage(int damage) {
        int damageToHealth = damage;

        // Si hay defensa, resta la defensa del daño
        if (defense > 0) {
            int remainingDamage = damage - defense;
            defense = Math.max(defense - damage, 0); // Actualiza la defensa

            // Si queda daño después de la defensa, se aplica a la salud
            if (remainingDamage > 0) {
                damageToHealth = remainingDamage;
            } else {
                damageToHealth = 0; // Todo el daño fue absorbido por la defensa
            }
        }

        // Aplica daño a la salud
        applyDamageToHealth(damageToHealth);
    }

    /* Método para aplicar daño a la salud */
    private void applyDamageToHealth(int damage) {
        health -= damage;
        health = Math.max(health, 0); // Asegúrate de que la salud no sea negativa
        JOptionPane.showMessageDialog(null, getName() + " ha recibido " + damage + " de daño. Salud restante: " + health);
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + getName() +
                "\nSalud: " + health +
                "\nPoder de ataque: " + attackPower +
                "\nDescripción: " + description);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    // Métodos getter
    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public abstract void getLoot();

    public abstract ImageIcon getSprite();

    public EnemyType getType() {
        return null;
    }
}