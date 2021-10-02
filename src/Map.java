import java.util.*;

public class Map {
    private List keys;
    private List values;

    public Map() {
        this.keys = new List();
        this.values = new List();
    }

    public Map(Object[] keys, Object[] values) {
        this.keys = new List(keys);
        this.values = new List(values);
    }

    public Map(List keys, List values) {
        this.keys = new List(keys);
        this.values = new List(values);
    }

    public Map(Map other) {
        this.keys = new List(other.keys);
        this.values = new List(other.values);
    }

    public void put(Object key, Object value) {
        if (this.keys.contains(key)) {
            this.values.set(value, this.keys.indexOf(key));
        } else {
            this.keys.add(key);
            this.values.add(value);
        }
    }

    public Object get(Object key) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            return this.values.get(index);
        } else return null;
    }

    public Object get(Object key, Object byDefault) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            Object result = this.values.get(index);
            if (result != null) {
                return result;
            } else {
                this.values.set(byDefault, index);
                return byDefault;
            }
        } else {
            this.put(key, byDefault);
            return byDefault;
        }
    }

    public Object remove(Object key) {
        int index = this.keys.indexOf(key);
        if (index != -1) {
            Object result = this.values.get(index);
            this.keys.remove(index);
            this.values.remove(index);
            return result;
        } else return null;
    }

    public boolean keyContains(Object key) {
        return this.keys.contains(key);
    }

    public List getKeys() {
        return new List(this.keys);
    }

    public List getValues() {
        return new List(this.values);
    }

    public List getEntries() {
        List result = new List();
        for (int i = 0; i < this.keys.size(); ++i) {
            Pair pair = new Pair();
            pair.setFirst(this.keys.get(i));
            pair.setSecond(this.values.get(i));
            result.add(pair);
        }
        return new List(result);
    }

    public int size() {
        return this.keys.size();
    }

    public boolean isEmpty() {
        return this.keys.isEmpty();
    }

}
