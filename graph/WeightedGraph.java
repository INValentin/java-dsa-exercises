package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class WeightedGraph {
    private class Node {
        String label;
        private List<Edge> edges = new ArrayList<>();

        Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            this.edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    private class NodeEntry {
        Node node;
        int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return this.from + "->" + this.to + "=" + this.weight;
        }
    }

    Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node node : nodes.values()) {
            System.out.print(node.label + " -> ");
            System.out.print(node.getEdges());
            System.out.println();
        }
        System.out.println(".....");
    }

    public List<String> getShortestPath(String start, String end) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        var firstNode = nodes.get(start);
        queue.add(new NodeEntry(firstNode, 0));
        distances.put(firstNode, 0);
        previousNodes.put(firstNode, null);
        var endNode = nodes.get(end);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (visited.contains(current.node)) {
                continue;
            }
            if (current.node == endNode)
                break;

            visited.add(current.node);

            var distance = distances.getOrDefault(current.node, Integer.MAX_VALUE);
            for (Edge edge : current.node.getEdges()) {
                if (!visited.contains(edge.to)) {
                    var currentDistance = distances.getOrDefault(edge.to, Integer.MAX_VALUE);
                    var newDistance = distance + edge.weight;
                    if (newDistance < currentDistance) {
                        distances.put(edge.to, newDistance);
                        previousNodes.put(edge.to, current.node);
                    }
                    queue.add(new NodeEntry(edge.to, Math.min(newDistance, currentDistance)));
                }
            }
        }

        List<String> list = new ArrayList<>();
        var el = endNode;
        while (el != null) {
            var from = previousNodes.get(el);
            list.add(el.label);
            el = from;
        }
        Collections.reverse(list);
        return list;
    }

    private boolean hasCycle(Node node, Set<Node> visited, Node parent) {
        visited.add(node);

        for (Edge edge : node.getEdges()) {
            if (visited.contains(edge.to)) {
                if (edge.to != parent)
                    return true;
            } else if (hasCycle(edge.to, visited, node))
                return true;
        }
        return false;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, visited, null))
                return true;
        }
        return false;
    }

    public WeightedGraph minSpanningTree() {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        var tree = new WeightedGraph();

        var startNode = nodes.values().iterator().next();
        tree.addNode(startNode.label);
        queue.addAll(startNode.getEdges());

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = queue.poll();
            if (tree.nodes.containsKey(minEdge.to.label))
                continue;

            var current = minEdge.from;
            tree.addNode(current.label);
            tree.addNode(minEdge.to.label);
            tree.addEdge(current.label, minEdge.to.label, minEdge.weight);

            for (Edge edge : minEdge.to.getEdges()) {
                if (!tree.nodes.containsKey(edge.to.label))
                    queue.add(edge);
            }

        }

        return tree;
    }

}
