package zhitnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**Матрица инцидентности.Граф является
 * обобщенным и параметризуется типом данных T,
 * который представляет данные, хранящиеся в
 * вершинах и ребрах графа.*/
public class IncidenceMatrixGraph<T> {
    private List<Vertex<T>> vertices;
    private List<Edge<T>> edges;
    private int[][] incidenceMatrix;

    /**конструктор класс.*/
    public IncidenceMatrixGraph(int vertexCount, int edgeCount) {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        incidenceMatrix = new int[vertexCount][edgeCount];
    }

    /**добавляет вершину.*/
    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /**удаляет вершину из списка vertices и
     * сдвигает остальные вершины в случае
     * удаления текущей вершины. Также удаляется
     * последний столбец и строка в матрице
     * инцидентности, так как они теперь неиспользуемые.*/
    public void removeVertex(Vertex<T> vertex) {
        int index = vertices.indexOf(vertex);
        if (index >= 0) {
            vertices.remove(index);

            // Сдвигаем остальные вершины в случае удаления текущей вершины
            for (int i = index; i < vertices.size(); i++) {
                for (int j = 0; j < edges.size(); j++) {
                    incidenceMatrix[i][j] = incidenceMatrix[i + 1][j];
                }
            }

            // Удаляем последний столбец и строку, так как они теперь неиспользуемые
            for (int i = 0; i < vertices.size(); i++) {
                incidenceMatrix[i] = incidenceMatrix[i].clone();
                incidenceMatrix[i] = Arrays.copyOf(incidenceMatrix[i], edges.size());
            }
        }
    }

    /**добавляет ребро.*/
    public void addEdge(Edge<T> edge) {
        edges.add(edge);
        int startIndex = vertices.indexOf(edge.getStart());
        int endIndex = vertices.indexOf(edge.getEnd());
        if (startIndex >= 0 && endIndex >= 0) {
            incidenceMatrix[startIndex][edges.indexOf(edge)] = 1;
            incidenceMatrix[endIndex][edges.indexOf(edge)] = -1;
        }
    }

    /**удаляет ребро из списка edges и сдвигает
     * остальные значения в матрице инцидентности.*/
    public void removeEdge(Edge<T> edge) {
        int index = edges.indexOf(edge);
        if (index >= 0) {
            edges.remove(index);
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = index; j < edges.size(); j++) {
                    incidenceMatrix[i][j] = incidenceMatrix[i][j + 1];
                }
            }
        }
    }

    /**возвращает список всех вершин.*/
    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    /**возвращает список всех ребер.*/
    public List<Edge<T>> getEdges() {
        return edges;
    }
}

