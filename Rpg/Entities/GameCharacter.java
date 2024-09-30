package rpg.entities;
import rpg.enums.Stats;

import java.util.HashMap;

public abstract class GameCharacter {

    protected String name;
    protected HashMap&lt;Stats, Integer&gt; stats;

    public GameCharacter(String name) {

        this.name = name;
        this.stats = new HashMap&lt;&gt;();
        initCharacter();
    }

    protected abstract void initCharacter();

    public boolean isAlive() {
        return stats.get(Stats.HP) &gt; 0;
    }

    public void attack(GameCharacter enemy) {

        String message = &quot;&quot;;
        String enemyName = enemy.getName();
        int damage = this.stats.get(Stats.ATTACK)
                - enemy.getStats().get(Stats.DEFENSE);
        int newHP = enemy.getStats().get(Stats.HP);
        if (damage &gt; 0) {

            newHP = enemy.getStats().get(Stats.HP) - damage;
            enemy.getStats().put(Stats.HP, newHP);
            message += String.format(&quot;&quot;&quot;
                    %s attacks %s for %d damage!
                    %s has %d HP left.
                    &quot;&quot;&quot;, this.name, enemyName, damage, enemyName, newHP);
        }
        else {
            message += String.format(&quot;&quot;&quot;
                    %s attacks %s but does no damage!
                    %s has %d HP left.
                    &quot;&quot;&quot;, this.name, enemyName, enemyName, newHP);
        }
        System.out.println(message);
    }

    public String getName() {
        return name;
    }

    public HashMap&lt;Stats, Integer&gt; getStats() {
        return stats;
    }
}
