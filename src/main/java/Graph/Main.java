package Graph;

import Graph.BFS.BFS;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);

        graph.add(4);
        graph.add(5);
        graph.addEdge(4,6);
        //graph.displayGraph();

        BFS.displayBFS(graph);
    }
}
