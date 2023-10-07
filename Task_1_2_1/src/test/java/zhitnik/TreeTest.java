package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeTest {

    @Test
    public void testIsEmpty() {
        // Create a tree with strings
        Tree<String> tree = new Tree<>("A");
        Node<String> root = tree.getRoot();

        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        Assertions.assertFalse(tree.isEmpty());
    }

    @Test
    public void testGetHeight() {
        // Create a tree with strings
        Tree<String> tree = new Tree<>("A");
        Node<String> root = tree.getRoot();

        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        Assertions.assertEquals(3, tree.getHeight());
    }

    @Test
    public void testBreadthFirstTraversal() {
        // Create a tree with strings
        Tree<String> tree = new Tree<>("A");
        Node<String> root = tree.getRoot();

        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        StringBuilder output = new StringBuilder();
        for (Node<String> node : new BreadthFirstIterator<>(root)) {
            output.append(node.getData()).append(" ");
        }

        Assertions.assertEquals("A B C D E F ", output.toString());
    }
}
