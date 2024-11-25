package items.miscs;
import entities.Player.*;
public  class BattleTartare extends Misc {
    private final int attackBoost;
    private final int defenseBoost;
    private final int duration;

    public BattleTartare() {
        super("Battle Tartare", "Aumenta el ataque y la defensa por 3 turnos.");
        this.attackBoost = 10;
        this.defenseBoost = 5;
        this.duration = 3;
    }


    public void use(Player player) {
        System.out.println("Has consumido Battle Tartare. Ataque aumentado en " + attackBoost +
                " y defensa aumentada en " + defenseBoost + " por " + duration + " turnos.");
        // Aquí aplicaríamos lógica para aumentar temporalmente ataque y defensa
        // Puede implicar un seguimiento de turnos y reducción de los efectos al expirar
    }


}