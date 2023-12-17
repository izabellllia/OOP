package zhitnik;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**some tests.*/
public class GraphTest {
    @Test
    public void testAddVertex() {
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> vertex = new Vertex<>(1);
        graph.addVertex(vertex);
        Assertions.assertTrue(graph.getVertices().contains(vertex));
    }

    @Test
    public void testAddEdge() {
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> start = new Vertex<>(1);
        Vertex<Integer> end = new Vertex<>(2);
        graph.addVertex(start);
        graph.addVertex(end);
        graph.addEdge(start, end, 10);
        Assertions.assertTrue(graph.getEdges().size() == 1);
    }

    @Test
    public void testSortVerticesByDistance() {
        Graph<String> graph = new Graph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        graph.addEdge(a, b, 2);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 1);
        graph.addEdge(b, d, 4);
        graph.addEdge(c, d, 3);
        graph.addEdge(d, e, 2);

        List<Vertex<String>> sortedVertices = graph.sortVerticesByDistance(a);

        assertEquals(a, sortedVertices.get(0));
        assertEquals(b, sortedVertices.get(1));
        assertEquals(c, sortedVertices.get(2));
        assertEquals(d, sortedVertices.get(3));
        assertEquals(e, sortedVertices.get(4));
    }

    @Test
    public void testRemoveVertex() {
        Graph<String> graph = new Graph<>();
        Vertex<String> vertex = new Vertex<>("A");
        graph.addVertex(vertex);
        graph.removeVertex(vertex);
        Assertions.assertFalse(graph.getVertices().contains(vertex));
    }

    @Test
    public void testRemoveEdge() {
        Graph<String> graph = new Graph<>();
        Vertex<String> start = new Vertex<>("A");
        Vertex<String> end = new Vertex<>("B");
        graph.addVertex(start);
        graph.addVertex(end);
        Edge<String> edge = new Edge<>(start, end, 5);
        graph.addEdge(start, end, 5);
        graph.removeEdge(edge);
        Assertions.assertFalse(graph.getEdges().contains(edge));
    }

    @Test
    public void testGetVertexData() {
        Graph<String> graph = new Graph<>();
        Vertex<String> vertex = new Vertex<>("A");
        graph.addVertex(vertex);
        assertEquals("A", graph.getVertexData(vertex));
    }

    @Test
    public void testSetVertexData() {
        Graph<String> graph = new Graph<>();
        Vertex<String> vertex = new Vertex<>("A");
        graph.addVertex(vertex);
        graph.setVertexData(vertex, "B");
        assertEquals("B", graph.getVertexData(vertex));
    }

    @Test
    public void testAddVertexAmG() {
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(4);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        List<Vertex<String>> vertices = graph.getVertices();
        assertEquals(3, vertices.size());
        Assertions.assertTrue(vertices.contains(vertexA));
        Assertions.assertTrue(vertices.contains(vertexB));
        Assertions.assertTrue(vertices.contains(vertexC));
    }

    @Test
    public void testRemoveVertexAmG() {
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(4);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        graph.removeVertex(vertexB);

        List<Vertex<String>> vertices = graph.getVertices();
        assertEquals(2, vertices.size());
        Assertions.assertTrue(vertices.contains(vertexA));
        Assertions.assertFalse(vertices.contains(vertexB));
        Assertions.assertTrue(vertices.contains(vertexC));
    }

    @Test
    public void testAddEdgeAmG() {
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(4);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexB, vertexC, 2);

        assertEquals(1, graph.getEdgeWeight(vertexA, vertexB));
        assertEquals(2, graph.getEdgeWeight(vertexB, vertexC));
    }

    @Test
    public void testRemoveEdgeAmG() {
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(4);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        graph.addEdge(vertexA, vertexB, 1);
        graph.addEdge(vertexB, vertexC, 2);

        graph.removeEdge(vertexA, vertexB);

        assertEquals(0, graph.getEdgeWeight(vertexA, vertexB));
        assertEquals(2, graph.getEdgeWeight(vertexB, vertexC));
    }

    @Test
    public void testGetVerticesAmG() {
        AdjacencyMatrixGraph<String> graph = new AdjacencyMatrixGraph<>(4);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);

        List<Vertex<String>> vertices = graph.getVertices();

        assertEquals(3, vertices.size());
        Assertions.assertTrue(vertices.contains(vertexA));
        Assertions.assertTrue(vertices.contains(vertexB));
        Assertions.assertTrue(vertices.contains(vertexC));
    }

    @Test
    public void testAddVertexAlG() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        Vertex<Integer> vertex = new Vertex<>(1);
        graph.addVertex(vertex);
        Assertions.assertTrue(graph.getVertexData(vertex) == 1);
    }

    @Test
    public void testRemoveVertexAlG() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        Vertex<Integer> vertex = new Vertex<>(1);

        graph.addVertex(vertex);
        graph.removeVertex(vertex);

        Assertions.assertFalse(graph.getVertices().contains(vertex));
    }

    @Test
    public void testAddEdgeAlG() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addEdge(vertex1, vertex2, 10);

        Assertions.assertTrue(graph.getEdges().size() > 0);
    }

    @Test
    public void testRemoveEdgeAlG() {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        graph.addEdge(vertex1, vertex2, 10);
        Edge<Integer> edge = new Edge<>(vertex1, vertex2, 10);

        graph.removeEdge(edge);
        Assertions.assertNull(graph.getEdgeData(edge));
    }

    @Test
    public void testSetVertexDataAlG() {
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Vertex<String> vertex = new Vertex<>("A");
        graph.addVertex(vertex);

        graph.setVertexData(vertex, "B");
        Assertions.assertTrue(graph.getVertexData(vertex).equals("B"));
    }

    @Test
    void testGetVertexDataAlG() {
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Vertex<String> v1 = new Vertex<>("A");
        graph.addVertex(v1);
        assertEquals("A", graph.getVertexData(v1));
    }

    @Test
    public void testAddEdgeAlG2() {
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addEdge(vertexA, vertexB, 5);
        assertEquals(1, graph.getEdges().size());
    }

    @Test
    public void testGetVertexDataAlg() {
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        Vertex<String> vertex = new Vertex<>("A");
        graph.addVertex(vertex);
        assertEquals("A", graph.getVertexData(vertex));
    }

    @Test
    public void testAddVertexImG() {
        IncidenceMatrixGraph<Integer> graph = new IncidenceMatrixGraph<>(5, 6);
        Vertex<Integer> vertex = new Vertex<>(1);
        graph.addVertex(vertex);
        Assertions.assertTrue(graph.getVertices().contains(vertex));
    }

    @Test
    public void testRemoveVertexImG() {
        IncidenceMatrixGraph<Integer> graph = new IncidenceMatrixGraph<>(5, 6);
        Vertex<Integer> vertex = new Vertex<>(1);
        graph.addVertex(vertex);
        graph.removeVertex(vertex);
        Assertions.assertFalse(graph.getVertices().contains(vertex));
    }

    @Test
    public void testGetVerticesImG() {
        IncidenceMatrixGraph<Integer> graph = new IncidenceMatrixGraph<>(5, 6);
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        List<Vertex<Integer>> vertices = graph.getVertices();
        assertEquals(2, vertices.size());
        Assertions.assertTrue(vertices.contains(vertex1));
        Assertions.assertTrue(vertices.contains(vertex2));
    }

    @Test
    public void testAddVertexImG2() {
        IncidenceMatrixGraph<String> graph = new IncidenceMatrixGraph<>(3, 3);
        graph.addVertex(new Vertex<>("A"));
        graph.addVertex(new Vertex<>("B"));
        graph.addVertex(new Vertex<>("C"));
        assertEquals(3, graph.getVertices().size());
    }

    @Test
    public void testAddVertexImG3() {
        IncidenceMatrixGraph<String> graph = new IncidenceMatrixGraph<>(5, 5); // создаем граф

        Vertex<String> vertex1 = new Vertex<>("A");
        graph.addVertex(vertex1); // добавляем вершину

        Assertions.assertTrue(graph.getVertices().contains(vertex1)); // проверяем, что вершина добавлена
    }

    @Test
    public void testAddEdgeImG() {
        IncidenceMatrixGraph<String> graph = new IncidenceMatrixGraph<>(5, 5); // создаем граф

        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Edge<String> edge = new Edge<>(vertex1, vertex2, 1);
        graph.addEdge(edge); // добавляем ребро

        Assertions.assertTrue(graph.getEdges().contains(edge)); // проверяем, что ребро добавлено
    }

    @Test
    public void testRemoveEdgeImG() {
        IncidenceMatrixGraph<String> graph = new IncidenceMatrixGraph<>(5, 5); // создаем граф

        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Edge<String> edge = new Edge<>(vertex1, vertex2, 1);
        graph.addEdge(edge);
        graph.removeEdge(edge); // удаляем ребро

        Assertions.assertFalse(graph.getEdges().contains(edge)); // проверяем, что ребро удалено
    }

    @Test
    public void testGetVertices() {
        // Создаем граф
        Graph<String> graph = new Graph<>();

        // Создаем вершины
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        Vertex<String> vertex3 = new Vertex<>("C");

        // Добавляем вершины в граф
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);

        // Получаем список вершин и проверяем их количество и наличие
        List<Vertex<String>> vertices = graph.getVertices();
        Assertions.assertEquals(3, vertices.size());
        Assertions.assertTrue(vertices.contains(vertex1));
        Assertions.assertTrue(vertices.contains(vertex2));
        Assertions.assertTrue(vertices.contains(vertex3));
    }

    @Test
    public void testGetEdges() {
        // Создаем граф
        Graph<String> graph = new Graph<>();

        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        Edge<String> edge = new Edge<>(vertex1, vertex2, 1);

        // Получаем список ребер и проверяем их количество и наличие
        List<Edge<String>> edges = graph.getEdges();
        Assertions.assertEquals(1, edges.size());
        Assertions.assertTrue(edges.contains(edge));
    }
}
