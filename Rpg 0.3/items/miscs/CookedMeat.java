package items.miscs;


import entities.Player.*;
import enums.Stats;

public class CookedMeat extends Misc {
    private final int healingAmount;

    public CookedMeat() {
        super("Cooked Meat", "Recupera 20 de salud.");
        this.healingAmount = 20;
    }


    public void use(Player player) {
        int currentHealth = player.getStats ( enums.Stats.HP );
        player.putStat ( Stats.HP, currentHealth + healingAmount );
        System.out.println ( "Has usado una Coked Meat. Salud restaurada en " + healingAmount );
    }
}

