package src.graphs.adjacencylist.map;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Traversal {

    public static void main(String... args) {
        Graph graph = new Graph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");

        graph.addEdge("a", "c");
        graph.addEdge("a", "b");
        graph.addEdge("b", "d");
        graph.addEdge("c", "e");
        graph.addEdge("d", "f");

        System.out.println("[DFS] Iterative : ");
        depthFirstPrintIterative(graph, "a");

        System.out.println("[DFS] Recursive : ");
        depthFirstPrintRecursive(graph, "a");

        System.out.println("[BFS] Iterative (Only) : ");
        breadthFirstSearch(graph, "a");
    }

    private static void breadthFirstSearch(Graph graph, String source) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.println(vertex);
            for (Vertex v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
    }

    private static void depthFirstPrintRecursive(Graph graph, String source) {
        System.out.println(source);
        for (Vertex v : graph.getAdjVertices(source)) {
            depthFirstPrintRecursive(graph, v.label); // no explicit base case since recursion stops when there are nothing in adjacency vertices
        }
    }

    private static void depthFirstPrintIterative(Graph graph, String source) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.println(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
    }
}