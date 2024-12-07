/*
   Esta enumeración (`enum`) define las estadísticas básicas que un jugador o enemigo puede tener en el juego, 
   específicamente: ataque, salud (HP) y defensa.
   Se utiliza para garantizar seguridad de tipo al manejar estadísticas en otras clases del juego.
*/

package enums;

public enum Stats {
        ATTACK,
        HP,
        LEVEL;
        public static final int EXPERIENCE = 98;
        Stats() {
        }
    }

