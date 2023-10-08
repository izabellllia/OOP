package zhitnik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**Test.*/
public class TreeTest {

    @Test
    public void testIsEmpty() {
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

    @Test
    public void testIsEmptyOnEmptyTree() {
        // Create an empty tree
        Tree<Integer> emptyTree = new Tree<>(null);
        Assertions.assertFalse(emptyTree.isEmpty());
    }

    @Test
    void testEquals() {
        Tree<String> tree1 = new Tree<>("A");
        Node<String> nodeB1 = new Node<>("B");
        Node<String> nodeC1 = new Node<>("C");
        Node<String> nodeD1 = new Node<>("D");
        Node<String> nodeE1 = new Node<>("E");
        Node<String> nodeF1 = new Node<>("F");

        tree1.getRoot().addChild(nodeB1);
        tree1.getRoot().addChild(nodeC1);
        tree1.getRoot().addChild(nodeD1);
        tree1.getRoot().addChild(nodeE1);
        tree1.getRoot().addChild(nodeF1);

        Tree<String> tree2 = new Tree<>("A");
        Node<String> nodeB2 = new Node<>("B");
        Node<String> nodeC2 = new Node<>("C");
        Node<String> nodeD2 = new Node<>("D");
        Node<String> nodeE2 = new Node<>("E");
        Node<String> nodeF2 = new Node<>("F");

        tree2.getRoot().addChild(nodeB2);
        tree2.getRoot().addChild(nodeC2);
        tree2.getRoot().addChild(nodeD2);
        tree2.getRoot().addChild(nodeE2);
        tree2.getRoot().addChild(nodeF2);

        Assertions.assertTrue(tree1.equals(tree2));
    }

    @Test
    void testNotEquals() {
        Tree<String> tree1 = new Tree<>("A");
        Node<String> nodeB1 = new Node<>("B");
        Node<String> nodeC1 = new Node<>("C");
        Node<String> nodeD1 = new Node<>("D");
        Node<String> nodeE1 = new Node<>("E");
        Node<String> nodeF1 = new Node<>("F");

        tree1.getRoot().addChild(nodeB1);
        tree1.getRoot().addChild(nodeC1);
        tree1.getRoot().addChild(nodeD1);
        tree1.getRoot().addChild(nodeE1);
        tree1.getRoot().addChild(nodeF1);

        Tree<String> tree2 = new Tree<>("A");
        Node<String> nodeB2 = new Node<>("B");
        Node<String> nodeC2 = new Node<>("C");
        Node<String> nodeD2 = new Node<>("D");
        Node<String> nodeE2 = new Node<>("E");

        tree2.getRoot().addChild(nodeB2);
        tree2.getRoot().addChild(nodeC2);
        tree2.getRoot().addChild(nodeD2);
        tree2.getRoot().addChild(nodeE2);

        Assertions.assertFalse(tree1.equals(tree2));
    }
}
