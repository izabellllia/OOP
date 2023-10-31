package zhitnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Представление реализации графа на основе списка смежности,
 * является обобщенным и параметризуется типом данных T,
 * который представляет данные, хранящиеся в
 * вершинах и ребрах графа.*/
public class AdjacencyListGraph<T> {
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    /**словарь, где ключом является вершина графа,
     * а значением - список ребер, связанных с данной вершиной.*/
     public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    /**добавляет вершину в словарь adjacencyList со списком пустых ребер.*/
     public void addVertex(Vertex<T> vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    /**удаляет вершину из словаря adjacencyList
     * и все ребра, связанные с данной вершиной.*/
     public void removeVertex(Vertex<T> vertex) {
        adjacencyList.remove(vertex);
        adjacencyList.values().forEach(edges -> edges.removeIf(edge -> edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)));
    }

    /**добавляет ребро между вершинами start и end
     * с заданным весом weight в список ребер,
     * связанных с вершиной start.*/
     public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        Edge<T> edge = new Edge<>(start, end, weight);
        adjacencyList.get(start).add(edge);
    }

    /**удаляет ребро из списка ребер, связанных с каждой вершиной графа.*/
     public void removeEdge(Edge<T> edge) {
        adjacencyList.values().forEach(edges -> edges.remove(edge));
    }

    /**получение вешины.*/
    public T getVertexData(Vertex<T> vertex) {
        return vertex.getData();
    }

    /**установление вершины.*/
    public void setVertexData(Vertex<T> vertex, T data) {
        vertex.setData(data);
    }

    /**получение ребра.*/
    public T getEdgeData(Edge<T> edge) {
        return edge.getData();
    }

    /**уставновление ребра.*/
    public void setEdgeData(Edge<T> edge, T data) {
        edge.setData(data);
    }

    /**возвращает список всех вершине.*/
    public List<Vertex<T>> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    /**возвращает список всех ребер.*/
    public List<Edge<T>> getEdges() {
        List<Edge<T>> allEdges = new ArrayList<>();
        adjacencyList.values().forEach(allEdges::addAll);
        return allEdges;
    }
}