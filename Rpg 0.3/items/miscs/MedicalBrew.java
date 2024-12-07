package items.miscs;
import entities.Player.*;
import enums.Stats;

public  class MedicalBrew extends Misc {
    private final int healingAmount;

    public MedicalBrew() {
        super ( "Medical Brew", "Restaura 50 puntos de salud." );
        this.healingAmount = 50;
    }


    public void use(Player player) {
        int currentHealth = player.getStats ( Stats.HP );
        player.putStat ( Stats.HP, currentHealth + healingAmount );
        System.out.println ( "Has usado una Medical Brew. Salud restaurada en " + healingAmount );
    }
}
