package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GraphTest{
    @Test
    public void testSortVerticesByDistance() {
        Graph<String> graph = new Graph<>();

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");
        Vertex<String> E = new Vertex<>("E");

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);

        graph.addEdge(A, B, 2);
        graph.addEdge(A, C, 4);
        graph.addEdge(B, C, 1);
        graph.addEdge(B, D, 4);
        graph.addEdge(C, D, 3);
        graph.addEdge(D, E, 2);

        List<Vertex<String>> sortedVertices = graph.sortVerticesByDistance(A);

        Assertions.assertEquals(A, sortedVertices.get(0));
        Assertions.assertEquals(B, sortedVertices.get(1));
        Assertions.assertEquals(C, sortedVertices.get(2));
        Assertions.assertEquals(D, sortedVertices.get(3));
        Assertions.assertEquals(E, sortedVertices.get(4));
    }
    
    @Test
    public void testAddVertexAMG() {
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
    public void testRemoveVertexAMG() {
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
    public void testAddEdgeAMG() {
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
    public void testRemoveEdgeAMG() {
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
    public void testGetVerticesAMG() {
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
