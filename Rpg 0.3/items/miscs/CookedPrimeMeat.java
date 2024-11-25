package items.miscs;

import entities.Player.*;
public class CookedPrimeMeat extends Misc {
    private final int healingAmount;

    public CookedPrimeMeat() {
        super ( "Cooked Prime Meat", "Recupera 35 de salud." );
        this.healingAmount = 35;
    }


    public void use(Player player) {
        int currentHealth = player.getStat ( Stats.HP );
        player.putStat ( Stats.HP, currentHealth + healingAmount );
        System.out.println ( "Has usado un CookedMeat Salud restaurada en " + currentHealth );
    }
}