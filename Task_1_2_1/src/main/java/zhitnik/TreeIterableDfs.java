package zhitnik;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**класс, который реализует интерфейс iterator node. Он позволяет
 * создать итератор для обхода узлов дерева в порядке DFS.*/
class TreeIterableDfs<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
    private Node<T> root;

    public TreeIterableDfs(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new zhitnik.TreeIterableDfs.DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<Node<T>> {
        private Stack<Node<T>> stack = new Stack<>();

        // поля для контроля модификации стека
        private int modCount = 0;
        private int expectedModCount = 0;

        {
            stack.push(root);
            modCount++;
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node<T> next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> current = stack.pop();
            for (int i = current.getChildren().size() - 1; i >= 0; i--) {
                stack.push(current.getChildren().get(i));
                modCount++;
            }
            expectedModCount = modCount;
            return current;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }
}
