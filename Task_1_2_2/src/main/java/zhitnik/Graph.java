package zhitnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;
    private Map<Vertex<T>, Integer> distances;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        distances = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void removeVertex(Vertex<T> vertex) {
        vertices.remove(vertex);
        edges.removeIf(edge -> edge.getStart().equals(vertex) || edge.getEnd().equals(vertex));
    }

    public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        Edge<T> edge = new Edge<>(start, end, weight);
        edges.add(edge);
    }

    public void removeEdge(Edge<T> edge) {
        edges.remove(edge);
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
        return vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public List<Vertex<T>> sortVerticesByDistance(Vertex<T> source) {
        distances.clear();
        distances.put(source, 0);

        for (Vertex<T> vertex : vertices) {
            if (!vertex.equals(source)) {
                distances.put(vertex, Integer.MAX_VALUE);
            }
        }

        visit(source);

        List<Vertex<T>> sortedVertices = new ArrayList<>(vertices);
        sortedVertices.sort((v1, v2) -> distances.get(v1) - distances.get(v2));
        return sortedVertices;
    }

    private void visit(Vertex<T> vertex) {
        int currentDistance = distances.get(vertex);
        for (Edge<T> edge : edges) {
            if (edge.getStart().equals(vertex)) {
                Vertex<T> neighbor = edge.getEnd();
                int newDistance = currentDistance + edge.getWeight();
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    visit(neighbor);
                }
            }
        }
    }
}