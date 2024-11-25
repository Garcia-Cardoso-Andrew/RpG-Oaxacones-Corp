package factory;

import entities.Enemy.EnemyType;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import entities.Enemy.Enemy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EnemyFactory {

    private static final Random random = new Random();
    private static final Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forJavaClassPath())
            .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));

    public static Enemy getEnemy() {
        // Obtiene todas las clases que extienden de Enemy
        Set<Class<? extends Enemy>> enemyClasses = reflections.getSubTypesOf(Enemy.class);
        List<Class<? extends Enemy>> classList = filterList(enemyClasses, EnemyType.BASIC);

        if (classList.isEmpty()) {
            return null; // Retorna null si no hay clases disponibles
        }

        // Selecciona un enemigo aleatorio
        return createRandomEnemy(classList);
    }

    private static Enemy createRandomEnemy(List<Class<? extends Enemy>> classList) {
        int randomIndex = random.nextInt(classList.size());
        try {
            return classList.get(randomIndex).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // Manejo de excepciones mejorado
            System.err.println("Error al crear una instancia de Enemy: " + e.getMessage());
            return null;
        }
    }

    private static List<Class<? extends Enemy>> filterList(Set<Class<? extends Enemy>> classSet, EnemyType enemyType) {
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();

        for (Class<? extends Enemy> enemyClass : classSet) {
            if (isEnemyType(enemyClass, enemyType)) {
                classListFiltered.add(enemyClass);
            }
        }
        return classListFiltered;
    }

    private static boolean isEnemyType(Class<? extends Enemy> enemyClass, EnemyType enemyType) {
        try {
            Enemy enemy = enemyClass.getDeclaredConstructor().newInstance();
            return enemy.getType() == enemyType;
        } catch (Exception e) {
            System.err.println("Error al determinar el tipo de enemigo: " + e.getMessage());
            return false; // Si hay un error, no se incluye la clase en la lista
        }
    }
}