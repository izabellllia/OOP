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
        final Node<String> nodeE = new Node<>("E");
        final Node<String> nodeF = new Node<>("F");


        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        Assertions.assertFalse(tree.isEmpty());
    }

    @Test
    public void testGetHeight() {
        Tree<String> tree = new Tree<>("A");
        Node<String> root = tree.getRoot();

        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        final Node<String> nodeE = new Node<>("E");
        final Node<String> nodeF = new Node<>("F");

        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        Assertions.assertEquals(3, tree.getHeight());
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

    @Test
    public void testDepthFirstIterator() {
        // Создаем дерево
        Node<String> root = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        final Node<String> nodeE = new Node<>("E");
        final Node<String> nodeF = new Node<>("F");
        root.addChild(nodeB);
        root.addChild(nodeC);
        nodeB.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);

        StringBuilder output = new StringBuilder();
        for (Node<String> node : new TreeIterableDfs<>(root)) {
            output.append(node.getData()).append(" ");
        }

        Assertions.assertEquals("A B D E C F ", output.toString());
    }

    @Test
    public void testRemoveLeaf() {
        // Create a tree structure for testing
        Node<String> root = new Node<>("Root");
        Node<String> child1 = new Node<>("Child 1");
        Node<String> child2 = new Node<>("Child 2");
        root.addChild(child1);
        root.addChild(child2);

        // Test removing a leaf node
        root.removeLeaf(child1);
        Assertions.assertFalse(root.getChildren().contains(child1));
    }

    @Test
    public void testRemoveRootNode() {
        // Create a tree structure for testing
        Node<String> root = new Node<>("Root");
        Node<String> child = new Node<>("Child");
        root.addChild(child);

        // Try to remove the root node, should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> root.removeLeaf(root));
    }

    @Test
    public void testRemoveNonExistingNode() {
        // Create a tree structure for testing
        Node<String> root = new Node<>("Root");
        Node<String> child = new Node<>("Child");

        // Try to remove a node that doesn't exist in the tree, should throw an exception
        Assertions.assertThrows(IllegalArgumentException.class, () -> root.removeLeaf(child));
    }
}