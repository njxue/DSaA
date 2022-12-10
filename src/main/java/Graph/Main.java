package Graph;

import Graph.BFS.BFS;
import Graph.DFS.DFS;
import Graph.Util.GraphUtil;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphUtil.generateUndirectedGraph();

        //graph.displayGraph();
        BFS.displayBFS(graph);
        DFS.displayDFSRecursive(graph);
        DFS.displayDFS(graph);
    }
}
