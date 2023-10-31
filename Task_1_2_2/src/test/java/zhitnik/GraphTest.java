package zhitnik;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**some tests.*/
public class GraphTest {
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

        List<Vertex<String>> sortedVertices = graph.sortVerticesByDistance(A);

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
}
