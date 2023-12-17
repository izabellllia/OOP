package zhitnik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Матрица смежности.
 * является обобщенным и параметризуется типом данных T,
 * который представляет данные, хранящиеся
 * в вершинах и ребрах графа.*/
public class AdjacencyMatrixGraph<T> {
    private List<Vertex<T>> vertices;
    private int[][] adjacencyMatrix;

    /**Конструктор класса инициализирует поля vertices и adjacencyMatrix.*/
    public AdjacencyMatrixGraph(int vertexCount) {
        vertices = new ArrayList<>();
        adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    /**добавляет вершину в список vertices.*/
    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    /**удаляет вершину из списка vertices и все ребра,
     * связанные с данной вершиной. При удалении вершины
     * также происходит сдвиг остальных вершин в матрице
     * смежности и удаление последнего столбца и строки.*/
    public void removeVertex(Vertex<T> vertex) {
        int index = vertices.indexOf(vertex);
        if (index >= 0) {
            vertices.remove(index);

            // Сдвигаем остальные вершины в случае удаления текущей вершины
            for (int i = index; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size() - 1; j++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i + 1][j];
                }
            }

            // Удаляем последний столбец и строку, так как они теперь неиспользуемые
            for (int i = 0; i < vertices.size(); i++) {
                adjacencyMatrix[i] = adjacencyMatrix[i].clone();
                adjacencyMatrix[i] = Arrays.copyOf(adjacencyMatrix[i], vertices.size());
            }
        }
    }

    /**добавляет ребро между вершинами start и end с
     * заданным весом weight в матрицу смежности.*/
    public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            adjacencyMatrix[startIndex][endIndex] = weight;
        }
    }

    /**удаляет ребро между вершинами start и end из матрицы смежности.*/
    public void removeEdge(Vertex<T> start, Vertex<T> end) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            adjacencyMatrix[startIndex][endIndex] = 0;
        }
    }

    /**возвращает вес ребра между вершинами start и end из матрицы смежности.*/
    public int getEdgeWeight(Vertex<T> start, Vertex<T> end) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            return adjacencyMatrix[startIndex][endIndex];
        }
        return 0;
    }

    /**возвращает список вершин графа.*/
    public List<Vertex<T>> getVertices() {
        return vertices;
    }
}
