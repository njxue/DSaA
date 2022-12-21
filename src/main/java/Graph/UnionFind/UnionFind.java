package Graph.UnionFind;

public interface UnionFind<T> {
    boolean find(T u, T v);
    void union(T u, T v);
}
