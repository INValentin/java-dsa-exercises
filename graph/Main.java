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

        WeightedGraph wGraph = new WeightedGraph();
        wGraph.addNode("A");
        wGraph.addNode("X");
        wGraph.addNode("B");
        wGraph.addNode("P");
        wGraph.addEdge("X", "A", 1);
        wGraph.addEdge("X", "B", 1);
        wGraph.addEdge("A", "P", 3);
        wGraph.addEdge("B", "P", 5);
        wGraph.addEdge("X", "P", 2);
        var path = wGraph.getShortestPath("X", "P");
        System.out.println(path);
        // wGraph.print();
        // graph.print();

        // graph.breathFirst("X");
        // var result = graph.topologicalSort();
        // System.out.println("-------");
        // System.out.println(result.toString());
        // System.out.println("-------");
        // System.out.println(graph.hasCycle());
    }
}