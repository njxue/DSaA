package Graph.UnionFind;

import java.util.HashMap;
import java.util.List;

public class WeightedUnion<T> implements UnionFind<T> {
    HashMap<T, T> componentMap = new HashMap<>();
    HashMap<T, Integer> sizeMap = new HashMap<>();

    public WeightedUnion(HashMap<T, T> initialMap, HashMap<T, Integer> initialSize) {
        componentMap = initialMap;
        sizeMap = initialSize;
    }

    public WeightedUnion(List<T> l) {
        l.forEach(t -> {
            componentMap.put(t, t);
            sizeMap.put(t, 1);
        });
    }

    @Override
    public boolean find(T u, T v) {
        T ur = getRoot(u);
        T vr = getRoot(v);
        return ur.equals(vr);
    }

    @Override
    public void union(T u, T v) {
        T ur = getRoot(u);
        T vr = getRoot(v);

        if (sizeMap.get(ur) > sizeMap.get(vr)) {
            componentMap.put(vr, ur);
            sizeMap.put(ur, sizeMap.get(ur) + sizeMap.get(vr));
        } else {
            componentMap.put(ur, vr);
            sizeMap.put(vr, sizeMap.get(ur) + sizeMap.get(vr));
        }
    }

    @Override
    public String toString() {
        return componentMap.toString();
    }

    private T getRoot(T t) {
        T r = t;
        while (!componentMap.get(r).equals(r)) {
            r = componentMap.get(r);
        }

        // Path compression
        while (!componentMap.get(t).equals(r)) {
            T oldParent = componentMap.get(t);
            componentMap.put(t, r);
            t = oldParent;
        }
        return r;
    }
}
