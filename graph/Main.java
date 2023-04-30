package graph;

import javax.xml.transform.Source;

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
        wGraph.addNode("B");
        wGraph.addNode("C");
        wGraph.addNode("D");

        wGraph.addEdge("A", "B", 3);
        wGraph.addEdge("B", "C", 2);
        wGraph.addEdge("B", "D", 4);
        wGraph.addEdge("A", "C", 1);
        wGraph.addEdge("D", "C", 5);

        wGraph.print();

        wGraph.minSpanningTree().print();

        // wGraph.addEdge("A", "P", 3);

        // var path = wGraph.getShortestPath("A", "B");
        // System.out.println(path);
        // wGraph.print();

        // var hasCycle = wGraph.hasCycle();
        // System.out.println("Has Cycle: " + hasCycle);
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