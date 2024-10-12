package items.miscs;

import Player.*;

public  abstract class CookedFishMeat extends Misc {
    private int healthRestore;

    public CookedFishMeat() {
        super("Cooked Fish Meat", "Recupera 10 de salud.");
        this.healthRestore = 10;
    }

    @Override
    public void use(Player player) {
        System.out.println("Has consumido Cooked Fish Meat. Salud recuperada: " + healthRestore + ".");
        // Aquí aplicaríamos la lógica para restaurar la salud del jugador
        player.restoreHealth(healthRestore);
    }

}
