package zhitnik;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    public void testRemoveEdge() {
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> start = new Vertex<>(1);
        Vertex<Integer> end = new Vertex<>(2);
        graph.addVertex(start);
        graph.addVertex(end);
        Edge<Integer> edge = new Edge<>(start, end, 10);
        graph.addEdge(start, end, 10);
        graph.removeEdge(edge);
        Assertions.assertTrue(graph.getEdges().isEmpty());
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

        Assertions.assertEquals(a, sortedVertices.get(0));
        Assertions.assertEquals(b, sortedVertices.get(1));
        Assertions.assertEquals(c, sortedVertices.get(2));
        Assertions.assertEquals(d, sortedVertices.get(3));
        Assertions.assertEquals(e, sortedVertices.get(4));
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
        Assertions.assertEquals(3, vertices.size());
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
        Assertions.assertEquals(2, vertices.size());
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

        Assertions.assertEquals(1, graph.getEdgeWeight(vertexA, vertexB));
        Assertions.assertEquals(2, graph.getEdgeWeight(vertexB, vertexC));
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

        Assertions.assertEquals(0, graph.getEdgeWeight(vertexA, vertexB));
        Assertions.assertEquals(2, graph.getEdgeWeight(vertexB, vertexC));
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

        Assertions.assertEquals(3, vertices.size());
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
        Assertions.assertEquals(2, vertices.size());
        Assertions.assertTrue(vertices.contains(vertex1));
        Assertions.assertTrue(vertices.contains(vertex2));
    }
}
