package Graph.UnionFind;

import java.util.HashMap;
import java.util.List;

public class QuickFind<T> implements UnionFind<T> {
    HashMap<T, T> componentMap = new HashMap<>();

    public QuickFind(HashMap<T, T> initialMap) {
        componentMap = initialMap;
    }

    public QuickFind(List<T> l) {
        l.forEach(t -> componentMap.put(t, t));
    }

    @Override
    public boolean find(T u, T v) { // O(1)
        return componentMap.get(u).equals(componentMap.get(v));
    }

    @Override
    public void union(T u, T v) { // O(n)
        T oldComponent = componentMap.get(u);
        T newComponent = componentMap.get(v);
        for (T t : componentMap.keySet()) {
            if (componentMap.get(t).equals(oldComponent)) {
                componentMap.put(t, newComponent);
            }
        }
    }

    @Override
    public String toString() {
        return componentMap.toString();
    }
}
