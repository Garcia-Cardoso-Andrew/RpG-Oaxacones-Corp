package items.miscs;

import Player.*;

public   class CookedFishMeat extends Misc {
    private int healthRestore;

    public CookedFishMeat() {
        super("Cooked Fish Meat", "Recupera 10 de salud.");
        this.healthRestore = 10;
    }

    public void use(Player player) {
        System.out.println("Has consumido Cooked Fish Meat. Salud recuperada: " + healthRestore + ".");
        // Aquí aplicaríamos la lógica para restaurar la salud del jugador
        player.restoreHealth(healthRestore);
    }

}
