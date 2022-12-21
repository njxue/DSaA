import java.util.ArrayList;
import java.util.List;

import Graph.BFS.BFS;
import Graph.Graphs.DirectedGraph;
import Graph.Graphs.WeightedGraph;
import Graph.Graphs.WeightedGraph.Node;
import Graph.SSSP.BellmanFord;
import Graph.SSSP.Dijkstra;
import Graph.TopologicalSort.DFS;
import Graph.TopologicalSort.Kahns;
import Graph.UnionFind.QuickFind;
import Graph.UnionFind.QuickUnion;
import Graph.UnionFind.WeightedUnion;
import Graph.Util.GraphUtil;
import Tree.AVLTree.AVLTree;
import Tree.Heap.MaxHeap;
import Tree.Heap.MinHeap;
import Tree.TreeBuilder;
import Tree.Util.PrettyPrint;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        WeightedUnion<Integer> wn = new WeightedUnion<>(l);
        wn.union(3, 4);
        wn.union(4, 9);
        wn.union(8, 0);
        wn.union(2, 3);
        wn.union(5, 6);
        wn.union(5, 9);
        wn.union(7, 3);
        wn.union(4, 8);
        wn.union(6, 1);
        System.out.println(wn);
        System.out.println(wn.find(8, 6));
        System.out.println(wn);
        System.out.println(wn.find(5, 6));
        System.out.println(wn);
    }
}
