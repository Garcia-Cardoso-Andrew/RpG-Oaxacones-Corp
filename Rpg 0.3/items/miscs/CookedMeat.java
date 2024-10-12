package items.miscs;


import Player.*;
public class CookedMeat extends Misc {
    private int healthRestore;

    public CookedMeat() {
        super("Cooked Meat", "Recupera 20 de salud.");
        this.healthRestore = 20;
    }


    public void use(Player player) {
        System.out.println("Has consumido Cooked Meat. Salud recuperada: " + healthRestore + ".");
        // Aquí aplicaríamos la lógica para restaurar la salud del jugador
        player.restoreHealth(healthRestore);
    }

}

