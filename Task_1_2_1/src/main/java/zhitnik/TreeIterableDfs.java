package zhitnik;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**класс, который реализует интерфейс iterator node. Он позволяет
 * создать итератор для обхода узлов дерева в порядке DFS.*/
class TreeIterableDfs<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
    private Node<T> root;

    /** реализует интерфейс iterator node, поэтому он
     * должен предоставить реализацию метода iterator().*/
    public TreeIterableDfs(Node<T> root) {
        this.root = root;
    }

    /** создает новый объект DepthFirstIterator,
     * который будет использоваться для итерации по дереву.*/
    @Override
    public Iterator<Node<T>> iterator() {
        return new zhitnik.TreeIterableDfs.DepthFirstIterator();
    }

    /**реализует интерфейс iterator node и предоставляет
     * методы для итерации по дереву в глубоком порядке.*/
    private class DepthFirstIterator implements Iterator<Node<T>> {
        private Stack<Node<T>> stack = new Stack<>();

        {
            stack.push(root);
        }

        /**переопределенный метод hasNext Iterator. Возвращает true,если очередь не пуста
         * (есть еще узлы для обхода), и false в противном случае.*/
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**переопределенный метод next интерфейса Iterator.
         *  Возвращает следующий узел для обхода в ширину.
         * Если очередь пуста, генерируется исключение NoSuchElementException.
         * Иначе, извлекается первый узел из очереди, и для каждого дочернего
         * узла текущего узла добавляется в
         * очередь. Возвращается извлеченный узел.*/
        @Override
        public Node<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<T> current = stack.pop();
            for (int i = current.getChildren().size() - 1; i >= 0; i--) {
                stack.push(current.getChildren().get(i));
            }
            return current;
        }
    }
}