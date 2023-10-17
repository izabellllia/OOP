package zhitnik;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**класс, который реализует интерфейс iterable node. Он позволяет
 * создать итератор для обхода узлов дерева в порядке BFS.*/
class TreeIterableBfs<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
    private Node<T> root;

    public TreeIterableBfs(Node<T> root) {
        this.root = root;
    }

    /**метод, переопределенный из интерфейса Iterable,
     * который создает и возвращает новый объект BreadthFirstIterator,
     * который будет использоваться для итерации по дереву.*/
    @Override
    public Iterator<Node<T>> iterator() {
        return new zhitnik.TreeIterableBfs.BreadthFirstIterator(root);
    }


    /**это вложенный класс, который реализует интерфейс
     * iterator node. Он реализует итерацию по узлам дерева в порядке BFS.*/
    private class BreadthFirstIterator<T> implements Iterator<Node<T>> {
        /**приватное поле, хранящее очередь узлов для обхода в ширину.*/
        private Queue<Node<T>> queue = new LinkedList<>();

        public BreadthFirstIterator(Node<T> root) {
            if (root != null) {
                queue.add(root);
            }
        }
        /**переопределенный метод hasNext Iterator. Возвращает true,если очередь не пуста
         * (есть еще узлы для обхода), и false в противном случае.*/

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
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
            Node<T> current = queue.poll();
            for (Node<T> child : current.getChildren()) {
                queue.offer(child);
            }
            return current;
        }
    }
}