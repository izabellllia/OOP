package zhitnik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**является обобщенным и параметризуется типом данных T,
 * который представляет данные, хранящиеся
 * в вершинах и ребрах графа.*/
public class Graph<T> {
    /**список вершин графа.*/
    private List<Vertex<T>> vertices;
    /**список ребер графа.*/
    private List<Edge<T>> edges;
    /**расстояние от начальной вершины до каждой другой.*/
    private Map<Vertex<T>, Integer> distances;

    /**Конструктор класса инициализирует
     * поля vertices, edges и distances.*/
     public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        distances = new HashMap<>();
    }

    /**добавляет вершину в список.*/
    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /**удаляет вершину из списка vertices и
     * все ребра, связанные с данной вершиной.*/
     public void removeVertex(Vertex<T> vertex) {
        vertices.remove(vertex);
        edges.removeIf(edge -> edge.getStart().equals(vertex) || edge.getEnd().equals(vertex));
    }

    /**добавляет ребро между вершинами start и end
     * с заданным весом weight в список edges.*/
     public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        Edge<T> edge = new Edge<>(start, end, weight);
        edges.add(edge);
    }

    /**удаляет ребро из списка edges.*/
     public void removeEdge(Edge<T> edge) {
        edges.remove(edge);
    }

    /**озвращает данные, хранящиеся в вершине vertex.*/
     public T getVertexData(Vertex<T> vertex) {
        return vertex.getData();
    }

    /**устанавливает данные data для вершины vertex.*/
     public void setVertexData(Vertex<T> vertex, T data) {
        vertex.setData(data);
    }

    /**возвращает данные, хранящиеся в ребре edge.*/
     public T getEdgeData(Edge<T> edge) {
        return edge.getData();
    }

    /**устанавливает данные data для ребра edge.*/
     public void setEdgeData(Edge<T> edge, T data) {
        edge.setData(data);
    }

    /**возвращает список вершин графа.*/
     public List<Vertex<T>> getVertices() {
        return vertices;
    }

    /**возвращает список ребер графа.*/
     public List<Edge<T>> getEdges() {
        return edges;
    }

    /**сортирует вершины графа по расстоянию от начальной вершины source
     * и возвращает отсортированный список вершин.
     * Для определения расстояния используется алгоритм обхода графа
     * в глубину (DFS) с подсчетом расстояний от начальной вершины до
     * каждой другой вершины.*/
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

    /**реализует алгоритм обхода графа в глубину (DFS) и
     * обновляет значения расстояний в distances.*/
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