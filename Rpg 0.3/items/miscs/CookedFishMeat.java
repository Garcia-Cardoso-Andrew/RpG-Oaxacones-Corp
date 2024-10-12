package items.miscs;

import Player.*;
import enums.Stats;

public   class CookedFishMeat extends Misc {
    private int healingAmount;

    public CookedFishMeat() {
        super("Cooked Fish Meat", "Recupera 10 de salud.");
        this.healingAmount = 10;
    }

    public void use(Player player) {
        int currentHealth = player.getStat ( enums.Stats.HP );
        player.putStat ( Stats.HP, currentHealth + healingAmount );
        System.out.println ( "Has usado una CookedFhishMeat. Salud restaurada en " + healingAmount );
    }
}


