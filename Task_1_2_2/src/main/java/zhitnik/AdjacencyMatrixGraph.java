package zhitnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AdjacencyMatrixGraph<T> {
    private List<Vertex<T>> vertices;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixGraph(int vertexCount) {
        vertices = new ArrayList<>();
        adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

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

    public void addEdge(Vertex<T> start, Vertex<T> end, int weight) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            adjacencyMatrix[startIndex][endIndex] = weight;
        }
    }

    public void removeEdge(Vertex<T> start, Vertex<T> end) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            adjacencyMatrix[startIndex][endIndex] = 0;
        }
    }

    public int getEdgeWeight(Vertex<T> start, Vertex<T> end) {
        int startIndex = vertices.indexOf(start);
        int endIndex = vertices.indexOf(end);
        if (startIndex >= 0 && endIndex >= 0) {
            return adjacencyMatrix[startIndex][endIndex];
        }
        return 0;
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }
}
