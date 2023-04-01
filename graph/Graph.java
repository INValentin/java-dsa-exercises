package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private class Node {
        public String label;

        Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

    }

    Graph() {

    }

    private List<LinkedList<Node>> list = new ArrayList<>();
    private HashMap<String, Integer> edges = new HashMap<>();

    public void addNode(String label) {
        var newNode = new Node(label);
        if (edges.containsKey(label)) {
            throw new IllegalArgumentException();
        }

        list.add(new LinkedList<>());
        edges.put(newNode.label, list.size() - 1);
    }

    public void removeNode(String label) {
        if (!edges.containsKey(label))
            throw new IllegalArgumentException();

        var index = (int) edges.get(label);
        list.remove(index);
        for (LinkedList<Node> linkedList : list) {
            linkedList.removeIf(node -> node.label == label);
        }
        for (String nodeLabel : edges.keySet()) {
            var val = edges.get(nodeLabel);
            if (val > index) {
                edges.put(nodeLabel, val - 1);
            }
        }
        edges.remove(label);
    }

    public void addEdge(String from, String to) {
        if (!edges.containsKey(from) || !edges.containsKey(to))
            throw new IllegalArgumentException();
        list.get(edges.get(from)).add(new Node(to));
    }

    public void removeEdge(String from, String to) {
        if (!edges.containsKey(from) || !edges.containsKey(to))
            throw new IllegalArgumentException();
        list.get(edges.get(from)).removeIf(node -> node.label == to);
    }

    public void print() {
        for (String label : edges.keySet()) {
            var index = edges.get(label);
            System.out.print(label + " -> ");
            System.out.print(list.get(index).toString());
            System.out.println();
        }
        System.out.println(".....");
    }
}
