package entities.enemy;

import entities.GameCharacter;
import entities.Player.Player;
import enums.Stats;

import javax.swing.*;

/**
 * Esta clase representa a un enemigo genérico del juego.
 * Proporciona propiedades como nombre, salud, poder de ataque, defensa y descripción.
 * Define comportamientos como recibir daño, atacar y mostrar información del enemigo.
 */
public abstract class Enemy extends GameCharacter {
    protected int attackPower;
    protected int defense;
    protected String description;
    protected EnemyType type;  // Añadido para manejar el tipo de enemigo

    /**
     * Constructor de la clase Enemy.
     * @param name Nombre del enemigo.
     * @param attackPower Poder de ataque del enemigo.
     * @param defense Defensa del enemigo.
     * @param description Descripción del enemigo.
     */
    public Enemy(String name, int attackPower, int defense, String description) {
        super(name);  // Llama al constructor de GameCharacter
        this.attackPower = attackPower;
        this.defense = defense;
        this.description = description;
        this.type = getRandomEnemyType();  // Asigna un tipo aleatorio al enemigo

        // Inicializar las estadísticas del enemigo
        stats.put(Stats.HP, 100);  // Valor por defecto para HP
        stats.put(Stats.ATTACK, attackPower);  // Poder de ataque
        stats.put(Stats.DEFENSE, defense);  // Defensa
    }

    // Método abstracto para el ataque (lo implementarán las subclases)
    public abstract String attack(Player player);

    /**
     * Método para recibir daño.
     * Resta la defensa antes de aplicar el daño a la salud.
     * @param damage El daño que recibe el enemigo.
     */
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

    /**
     * Método para aplicar daño a la salud.
     * Asegura que la salud no se vuelva negativa.
     * @param damage El daño que se va a aplicar.
     */
    private void applyDamageToHealth(int damage) {
        Integer health = stats.get(Stats.HP);
        if (health != null) {
            stats.put(Stats.HP, Math.max(health - damage, 0));  // Actualiza HP
            JOptionPane.showMessageDialog(null, getName() + " ha recibido " + damage + " de daño. Salud restante: " + stats.get(Stats.HP));
        }
    }

    /**
     * Método para obtener un tipo aleatorio de enemigo.
     * Asigna un tipo entre BASIC, ALPHA o BOSS.
     * @return Un tipo aleatorio de enemigo.
     */
    private EnemyType getRandomEnemyType() {
        int randomIndex = (int) (Math.random() * 3);  // Aleatorio entre 0 y 2
        switch (randomIndex) {
            case 0:
                return EnemyType.BASIC;
            case 1:
                return EnemyType.ALPHA;
            case 2:
                return EnemyType.BOSS;
            default:
                return EnemyType.BASIC;  // Por defecto, BASIC
        }
    }

    /**
     * Método para mostrar la información del enemigo.
     * Imprime las estadísticas y el tipo del enemigo.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();  // Llama al método displayInfo() de GameCharacter
        System.out.println("Descripción: " + description + "\nTipo: " + type);
    }

    // Métodos getter y setter
    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public EnemyType getType() {
        return type;
    }

    public void setType(EnemyType type) {
        this.type = type;
    }

    // Métodos abstractos que deberán ser implementados en las subclases
    public abstract void getLoot();

    public abstract ImageIcon getSprite();
}
