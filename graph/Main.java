package graph;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("B", "P");
        graph.addEdge("A", "P");
        graph.addEdge("A", "B");
        graph.addEdge("P", "B");
        graph.print();

        graph.breathFirst("X");
        var result = graph.topologicalSort();
        System.out.println("-------");
        System.out.println(result.toString());
        System.out.println("-------");
        System.out.println(graph.hasCycle());
    }
}