package src.graphs.adjacencylist.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a graph using a Map of adjacency list.
 */
class Graph {
    Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void addEdge(String label1, String label2) {
        adjVertices.get(new Vertex(label1)).add(new Vertex(label2));
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("\nGraph [\n");
        for(Map.Entry<Vertex, List<Vertex>> entry : adjVertices.entrySet()) {
            stringBuffer.append("\t[" + entry.getKey().label + "] => [" + entry.getValue().stream().map(v -> v.label).collect(Collectors.joining(",")) + "]\n");
        }
        stringBuffer.append("]\n");
        return stringBuffer.toString();
    }
}