package graph;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "D");
        graph.addEdge("A", "B");
        graph.addEdge("D", "A");
        graph.addEdge("C", "B");
        graph.addEdge("B", "C");

        graph.print();
        graph.removeEdge("C", "B");
        graph.removeNode("B");
        graph.print();

    }
}