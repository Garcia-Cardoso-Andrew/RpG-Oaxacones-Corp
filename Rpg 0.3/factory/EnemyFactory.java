package factory;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import entities.enemy.Enemy;
import entities.enemy.EnemyType;
import entities.Player.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Clase EnemyFactory que se encarga de generar instancias aleatorias de enemigos en el juego.
 */
public class EnemyFactory {

    // Objeto Random para generar valores aleatorios
    private static final Random random = new Random();

    /**
     * Método estático que devuelve una instancia aleatoria de una subclase de Enemy.
     *
     * @return instancia de un enemigo aleatorio o un enemigo por defecto si ocurre un error.
     */
    public static Enemy getEnemy() {
        // Configura Reflections para buscar clases en el classpath
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())  // Escanea el classpath de Java
                .setScanners(new SubTypesScanner()));  // Escanea subtipos

        // Obtiene todas las clases que extienden Enemy
        Set<Class<? extends Enemy>> enemyClasses = reflections.getSubTypesOf(Enemy.class);

        // Filtra las clases para obtener solo las de tipo BASIC (se puede cambiar el tipo si es necesario)
        List<Class<? extends Enemy>> classList = filterList(new ArrayList<>(enemyClasses), EnemyType.BASIC);

        // Si la lista de enemigos está vacía después de intentar ambos casos, lanza una excepción o crea un enemigo por defecto
        if (classList == null || classList.isEmpty()) {
            System.err.println("No hay enemigos disponibles para generar.");
            // Aquí, devolvemos un enemigo por defecto en lugar de devolver null
            return new Enemy("Enemigo Desconocido", 100, 20,  "Enemigo genérico.") {
                @Override
                protected void initCharacter() {
                    // Inicializa cualquier comportamiento adicional necesario
                }

                @Override
                public String attack(Player player) {
                    return "El Enemigo Desconocido ataca!";
                }

                @Override
                public void getLoot() {
                    // Lógica de loot para el enemigo genérico
                }

                @Override
                public ImageIcon getSprite() {
                    return null; // O puedes devolver una imagen por defecto si la tienes
                }

                @Override
                public EnemyType getType() {
                    return EnemyType.BASIC; // O el tipo que prefieras
                }
            };
        }

        try {
            // Selecciona una clase aleatoria de la lista filtrada o no filtrada y crea una instancia
            int randomIndex = random.nextInt(classList.size());
            return classList.get(randomIndex).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            // Retornamos un enemigo por defecto en caso de error
            return new Enemy("Enemigo Desconocido", 100, 20,  "Enemigo genérico.") {
                @Override
                protected void initCharacter() {
                    // Inicializa cualquier comportamiento adicional necesario
                }

                @Override
                public String attack(Player player) {
                    return "El Enemigo Desconocido ataca!";
                }

                @Override
                public void getLoot() {
                    // Lógica de loot para el enemigo genérico
                }

                @Override
                public ImageIcon getSprite() {
                    return null; // O puedes devolver una imagen por defecto si la tienes
                }

                @Override
                public EnemyType getType() {
                    return EnemyType.BASIC; // O el tipo que prefieras
                }
            };
        }
    }

    /**
     * Método privado que filtra una lista de clases de enemigos según el tipo de enemigo.
     *
     * @param classList Lista de clases de enemigos.
     * @param enemyType Tipo de enemigo a filtrar.
     * @return Lista filtrada de clases que coinciden con el tipo de enemigo.
     */
    private static List<Class<? extends Enemy>> filterList(List<Class<? extends Enemy>> classList, EnemyType enemyType) {
        // Verifica si la lista está vacía o nula
        if (classList == null || classList.isEmpty()) {
            return new ArrayList<>();  // Retorna una lista vacía si la lista original es nula o vacía
        }

        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();  // Lista para almacenar los enemigos filtrados

        // Itera sobre cada clase de la lista de enemigos
        for (Class<? extends Enemy> enemyClass : classList) {
            try {
                // Crea una instancia temporal del enemigo para verificar su tipo
                Enemy enemy = enemyClass.getDeclaredConstructor().newInstance();

                // Si el tipo del enemigo coincide con el tipo deseado, se agrega a la lista filtrada
                if (enemy.getType() == enemyType) {
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {
                System.err.println("Error al intentar crear una instancia de la clase: " + enemyClass.getName());
            }
        }

        // Devuelve la lista de enemigos filtrados
        return classListFiltered;
    }
}
