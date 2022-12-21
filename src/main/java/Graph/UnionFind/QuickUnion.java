package Graph.UnionFind;

import java.util.HashMap;
import java.util.List;

public class QuickUnion<T> implements UnionFind<T> {

    HashMap<T, T> componentMap = new HashMap<>();

    public QuickUnion(HashMap<T, T> initialMap) {
        componentMap = initialMap;
    }

    public QuickUnion(List<T> l) {
        l.forEach(t -> componentMap.put(t, t));
    }

    @Override
    public boolean find(T u, T v) { // O(n)
        T ur = getRoot(u);
        T vr = getRoot(v);
        return ur.equals(vr);
    }

    @Override
    public void union(T u, T v) { // O(n)
        T ur = getRoot(u);
        T vr = getRoot(v);
        componentMap.put(vr, ur);
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
        return r;
    }
}
