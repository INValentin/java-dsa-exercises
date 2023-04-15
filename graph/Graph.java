package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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

    private Map<String, LinkedList<Node>> adjacencyList = new HashMap<>();
    private HashMap<String, Node> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void removeNode(String label) {
        for (LinkedList<Node> linkedList : adjacencyList.values()) {
            linkedList.removeIf(n -> n.label == label);
        }
        nodes.remove(label);
        adjacencyList.remove(label);
    }

    public void addEdge(String from, String to) {
        if (!nodes.containsKey(from) || !nodes.containsKey(to))
            throw new IllegalArgumentException();
        if (adjacencyList.get(from) == null)
            adjacencyList.put(from, new LinkedList<>());
        adjacencyList.get(from).add(nodes.get(to));
    }

    public void removeEdge(String from, String to) {
        if (!nodes.containsKey(from) || !nodes.containsKey(to))
            throw new IllegalArgumentException();
        adjacencyList.get(from).removeIf(node -> node.label == to);
    }

    private void depthFirst(String label, Set<String> visited) {
        if (visited.contains(label))
            return;
        visited.add(label);
        for (Node neighbor : adjacencyList.get(label)) {
            depthFirst(neighbor.label, visited);
        }
    }

    public void depthFirstIter(String start) {
        if (!nodes.containsKey(start))
            throw new IllegalArgumentException();
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.empty()) {
            var current = stack.pop();
            if (visited.contains(current))
                continue;

            for (Node neighbor : adjacencyList.get(current)) {
                stack.push(neighbor.label);
            }
            visited.add(current);
        }

    }

    public void breathFirst(String start) {
        if (!nodes.containsKey(start))
            throw new IllegalArgumentException();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (visited.contains(current))
                continue;
            visited.add(current);
            if (adjacencyList.get(current) == null)
                continue;
            for (Node node : adjacencyList.get(current)) {
                if (!visited.contains(node.label))
                    queue.add(node.label);
            }
        }
    }

    public void depthFirst(String start) {
        if (!nodes.containsKey(start))
            throw new IllegalArgumentException();
        depthFirst(start, new HashSet<>());
    }

    private void topologicalSort(String start, Stack<String> stack, Set<String> visited) {
        visited.add(start);

        if (adjacencyList.get(start) != null) {
            for (Node node : adjacencyList.get(start)) {
                if (!visited.contains(node.label))
                    topologicalSort(node.label, stack, visited);
            }
        }
        stack.push(start);
    }

    public List<String> topologicalSort() {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String label : nodes.keySet()) {
            topologicalSort(label, stack, visited);
        }
        while (!stack.isEmpty())
            result.add(stack.pop());
        return result;
    }

    private boolean hasCycle(String start, Set<String> visited, Set<String> visiting) {
        boolean isCircular = false;
        visiting.add(start);
        
        if (adjacencyList.get(start) != null) {
            for (Node node : adjacencyList.get(start)) {
                if (visiting.contains(node.label)) {
                    isCircular = true;
                    break;
                }
                if (!visited.contains(node.label))
                    isCircular = hasCycle(node.label, visited, visiting);
            }
        }

        visiting.remove(start);
        visited.add(start);
        return isCircular;
    }

    public boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> visiting = new HashSet<>();
        boolean isCircular = false;

        for (String label : nodes.keySet()) {
            if (hasCycle(label, visited, visiting)) {
                isCircular = true;
                break;
            }
        }

        return isCircular;
    }

    public void print() {
        for (String label : adjacencyList.keySet()) {
            System.out.print(label + " -> ");
            System.out.print(adjacencyList.get(label).toString());
            System.out.println();
        }
        System.out.println(".....");
    }
}
