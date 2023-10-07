package zhitnik;

public class TreeTest {
    public static void main(String[] args) {
        // Create a tree with integers
        Tree<Integer> tree = new Tree<>(1);
        Node<Integer> root = tree.getRoot();

        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);

        root.addChild(node2);
        root.addChild(node3);
        node2.addChild(node4);
        node2.addChild(node5);
        node3.addChild(node6);

        // Test isEmpty()
        System.out.println("Is tree empty? " + tree.isEmpty()); // false

        // Test getHeight()
        System.out.println("Tree height: " + tree.getHeight()); // 3

        // Test BreadthFirstIterator
        System.out.println("Breadth-First Traversal:");
        for (Node<Integer> node : new BreadthFirstIterator<>(root)) {
            System.out.print(node.getData() + " "); // 1 2 3 4 5 6
        }
    }
}
