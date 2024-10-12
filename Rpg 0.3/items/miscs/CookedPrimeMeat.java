package items.miscs;


public class CookedPrimeMeat extends Misc {
    private int healthRestore;

    public CookedPrimeMeat() {
        super("Cooked Prime Meat", "Recupera 35 de salud.");
        this.healthRestore = 35;
    }

    @Override
    public void use(Player player) {
        System.out.println("Has consumido Cooked Prime Meat. Salud recuperada: " + healthRestore + ".");
        // Aquí aplicaríamos la lógica para restaurar la salud del jugador
        player.restoreHealth(healthRestore);
}
}