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
import Graph.Util.GraphUtil;
import Tree.AVLTree.AVLTree;
import Tree.Heap.MaxHeap;
import Tree.Heap.MinHeap;
import Tree.TreeBuilder;
import Tree.Util.PrettyPrint;

public class Main {
    public static void main(String[] args) {
        MinHeap heap = MinHeap.heapify(new int[] {4,8,2,1,9,3,6,7,8,4,7,3,7,9,2,10});
    }
}
