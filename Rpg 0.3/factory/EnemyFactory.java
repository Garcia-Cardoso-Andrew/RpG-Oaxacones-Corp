package factory;

import entities.enemy.EnemyType;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import entities.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class EnemyFactory {

    private static final Random random = new Random();

    public static Enemy getEnemy() {
        // Configura Reflections para buscar clases en el classpath
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new FieldAnnotationsScanner()));

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
        try {
            int randomIndex = random.nextInt(classList.size());
            return classList.get(randomIndex).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones mejorado
            return null;
        }
    }

    private static List<Class<? extends Enemy>> filterList(Set<Class<? extends Enemy>> classSet, EnemyType enemyType) {
        List<Class<? extends Enemy>> classListFiltered = new ArrayList<>();

        for (Class<? extends Enemy> enemyClass : classSet) {
            try {
                Enemy enemy = enemyClass.getDeclaredConstructor().newInstance();
                if (enemy.getType() == enemyType) {
                    classListFiltered.add(enemyClass);
                }
            } catch (Exception e) {
                e.printStackTrace(); // Manejo de excepciones mejorado
            }
        }
        return classListFiltered;
    }
}