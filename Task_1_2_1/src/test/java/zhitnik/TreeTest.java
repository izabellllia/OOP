package zhitnik;

import java.util.ConcurrentModificationException;
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
    void testCorrectHierarchy() {
        Tree<String> tree = new Tree<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        tree.getRoot().addChild(nodeB); // "A" -> "B", "C", "D", "E"
        tree.getRoot().addChild(nodeC);
        tree.getRoot().addChild(nodeD);
        tree.getRoot().addChild(nodeE);

        nodeE.addChild(nodeF); // "E" -> "F"

        Assertions.assertEquals(4, tree.getRoot().getChildren().size());
        Assertions.assertEquals("F", nodeE.getChildren().get(0).getData());
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
    public void testBreadthFirstTraversalWithMultipleLevels() {
        Tree<Integer> tree = new Tree<>(1);
        Node<Integer> root = tree.getRoot();
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        final Node<Integer> node5 = new Node<>(5);
        final Node<Integer> node6 = new Node<>(6);

        root.addChild(node2);
        root.addChild(node3);
        node2.addChild(node4);
        node2.addChild(node5);
        node3.addChild(node6);

        StringBuilder output = new StringBuilder();
        for (Node<Integer> node : new TreeIterableBfs<>(root)) {
            output.append(node.getData()).append(" ");
        }

        Assertions.assertEquals("1 2 3 4 5 6 ", output.toString());
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

    void testConcurrentModificationException() {
        // Создание дерева с данными
        Node<String> root = new Node<>("Root");
        Node<String> child1 = new Node<>("Child 1");
        Node<String> child2 = new Node<>("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        TreeIterableDfs<String> treeIterable = new TreeIterableDfs<>(root);

        // Проверка на возникновение ConcurrentModificationException
        Assertions.assertThrows(ConcurrentModificationException.class, () -> {
            var iterator = treeIterable.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                root.addChild(new Node<>("")); // модификация структуры дерева во время итерации
            }
        });
    }

    @Test
    void testGetTreeFromAnyNode() {
        Tree<String> tree = new Tree<>("Root");
        Node<String> childNode = new Node<>("Child");
        tree.getRoot().addChild(childNode);
        Assertions.assertEquals(tree, childNode.getData());
    }

}