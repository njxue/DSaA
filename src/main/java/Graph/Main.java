package Graph;

import Graph.BFS.BFS;
import Graph.DFS.DFS;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 7);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(2, 7);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);

        graph.addEdge(8, 9);

        graph.add(10);

        //graph.displayGraph();
        BFS.displayBFS(graph);
        DFS.displayDFS(graph);
    }
}
