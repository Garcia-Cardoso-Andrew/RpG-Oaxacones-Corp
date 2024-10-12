package enums;
import enums.Stats;
import java.util.Map;
import java.util.Set;

public enum ItemType implements Map<Stats, Integer> {
    Arma,
    Armadura,
    Miscelaneo,
    ;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Integer get(Object key) {
        return 0;
    }

    @Override
    public Integer put(Stats key, Integer value) {
        return 0;
    }

    @Override
    public Integer remove(Object key) {
        return 0;
    }

    @Override
    public void putAll(Map<? extends Stats, ? extends Integer> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Stats> keySet() {
        return Set.of ();
    }

    @Override
    public Set<Entry<Stats, Integer>> entrySet() {
        return Set.of ();
    }
}