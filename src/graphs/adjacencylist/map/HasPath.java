package src.graphs.adjacencylist.map;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class HasPath {

    private static class Edge {
        String v1, v2;

        Edge(String v1, String v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public static void main( String ... args ) {
        
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("i", "j"));
        edgeList.add(new Edge("k", "i"));
        edgeList.add(new Edge("m", "k"));
        edgeList.add(new Edge("k", "j"));
        edgeList.add(new Edge("k", "l"));
        edgeList.add(new Edge("o", "n"));

        Graph graph = buildGraph(edgeList);
        System.out.println(graph);

        System.out.println("HasPath between i and l : " + hashPathDepthFirstRecursive(graph, "i", "l", new LinkedHashSet<>()) );
        System.out.println("HasPath between k and n : " + hashPathDepthFirstRecursive(graph, "k", "n", new LinkedHashSet<>()) );
    }

    private static boolean hashPathDepthFirstRecursive(Graph graph, String source, String destination, Set<String> visited) {

        if(Objects.equals(source, destination)) {
            return true;
        }

        for (Vertex neighbour : graph.getAdjVertices(source)) {
            if(visited.contains(neighbour.label)) continue;
            visited.add(neighbour.label);
            if(hashPathDepthFirstRecursive(graph, neighbour.label, destination, visited)) return true;
        }

        return false;
    }

    /**
     * Converts the edgelist provided into an adjacency graph.
     * 
     * @param edgeList
     * @return <code>Graph</code> based on edgelist
     */
    private static Graph buildGraph(List<Edge> edgeList) {
        Graph graph = new Graph();
        for(Edge edge : edgeList) {
            String firstVertexLabel = edge.v1;
            String secondVertexLabel = edge.v2;
            graph.addVertex(firstVertexLabel);
            graph.addVertex(secondVertexLabel);
            
            //assume undirected so add to and from first and second
            
            graph.addEdge(firstVertexLabel, secondVertexLabel);
            graph.addEdge(secondVertexLabel, firstVertexLabel);
        }
        return graph;
    }
}