package zhitnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void removeVertex(Vertex<T> vertex) {
        adjacencyList.remove(vertex);
        adjacencyList.values().forEach(edges -> edges.removeIf(edge -> edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)));
    }

    public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        Edge<T> edge = new Edge<>(start, end, weight);
        adjacencyList.get(start).add(edge);
    }

    public void removeEdge(Edge<T> edge) {
        adjacencyList.values().forEach(edges -> edges.remove(edge));
    }

    public T getVertexData(Vertex<T> vertex) {
        return vertex.getData();
    }

    public void setVertexData(Vertex<T> vertex, T data) {
        vertex.setData(data);
    }

    public T getEdgeData(Edge<T> edge) {
        return edge.getData();
    }

    public void setEdgeData(Edge<T> edge, T data) {
        edge.setData(data);
    }

    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public List<Edge<T>> getEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        adjacencyList.values().forEach(allEdges::addAll);
        return allEdges;
    }
}