package rpg.entities.rpg.enums;

import java.util.HashMap;

 class Player {
    private  Object CRITICAL_HIT_DAMAGE = 0;
    private  int HP = 1;
    private  int MAX_HP = 0;
    private  int MP = 0;
    private  int MAX_MP = 0;
    private  int ATTACK = 0;
    private  int DEFENSE = 0;
    private  int SPEED = 0;
    private  int DEXTERITY = 0;
    private  int ACCURACY =0;
    private  int EVATION = 0;
    private  double CRITICAL_HIT_CHANCE =0;
    private int lUCK= 0;
    private String Name ;
    private HashMap<String, Integer> stats;

    private Player(){
        this.Name= "Pedro";
        this.HP=200;
        this.MAX_HP=200;
        this.MP=300;
        this.MAX_MP=300;
        this.ATTACK=25;
        this.DEFENSE=87;
        this.SPEED=96;
        this.DEXTERITY=500;
        this.lUCK=3;
        this.ACCURACY=56;
        this.EVATION=65;
        this.CRITICAL_HIT_CHANCE=0.001;
        this.CRITICAL_HIT_DAMAGE= (ATTACK*100);
        this.stats=new HashMap<String, Integer>();


    }


    public boolean isAlive() {
        return this.stats.get("health") > 0;
    }

    public void attack(Enemy opponent) {
        int attackPower = this.stats.get("attackPower");
        opponent.takeDamage(attackPower);
        System.out.println(Name + " ataca a " + opponent.getName() + " por " + attackPower + " de daño!");
    }

    public void takeDamage(int damage) {
        int currentHealth = this.stats.get("health");
        currentHealth -= damage;
        if (HP < 0) HP = 0; // Evitar salud negativa
        this.stats.put("health", currentHealth); // Actualizamos el valor en el HashMap

    }

     public String getName() {
         return Name;
     }

     public int getHealth() {
         return this.stats.get("health");
     }

     public void displayInfo() {
         System.out.println("jugador: " + Name + " | Salud: " + this.stats.get("HP") + " | Poder de ataque: " + this.stats.get("ATTACK") );
     }

 }
