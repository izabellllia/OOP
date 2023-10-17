package zhitnik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**Класс Tree представляет дерево и имеет корневой узел. Он предоставляет
 * методы для проверки, пустое ли дерево, и для получения высоты дерева.*/
class Tree<T> {
    /**приватное поле, представляющее корневой узел дерева.*/
    private Node<T> root;

    /**конструктор класса, cоздает новый объект с
     * переданными данными и устанавливает его как корень дерева.*/
    public Tree(T data) {
        this.root = new Node<>(data);
    }

    /**метод, возвращающий корневой узел дерева.*/
    public Node<T> getRoot() {
        return root;
    }

    /**метод, устанавливающий переданный узел как корень дерева.*/
    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**метод, проверяющий, пустое ли дерево (корневой узел равен null)
     * возвращает true, если дерево пустое, иначе false.*/
    public boolean isEmpty() {
        return root == null;
    }

    /**метод возварщает высоту дерева.**/
    public int getHeight() {
        return getHeight(root);
    }

    /**приватный рекурсивный метод, вычисляющий высоту дерева,
     * начиная с переданного узла. Если узел равен null, возвращает 0.
     * Иначе, инициализирует переменную height значением 0 и для каждого ребенка
     * узла вызывает рекурсивно метод getHeight, сравнивая возвращаемое значение с текущим
     * значением height и присваивая максимальное значение. Возвращает height + 1,
     * чтобы учесть текущий уровень узла.*/
    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int height = 0;
            for (Node<T> child : node.getChildren()) {
                height = Math.max(height, getHeight(child));
            }
            return height + 1;
        }
    }

    /**сравнивает текущее дерево с переданным объектом. Если объекты равны по ссылке, то они равны.
     * Если переданный объект является null или принадлежит другому классу, то они не равны.
     * Затем метод сравнивает корневые узлы двух деревьев с помощью метода Objects.equals,
     * который сравнивает объекты на равенство, учитывая возможность null значений.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tree<?> other = (Tree<?>) obj;
        return Objects.equals(root, other.root);
    }

}

/**Представляет узел в дереве. Каждый узел имеет данные типа T и список дочерних узлов.
 * Он предоставляет методы для получения и установки данных и дочерних узлов,
 * а также для добавления дочернего узла.*/
class Node<T> {
    /**приватное поле, хранящее данные узла.*/
    private T data;
    /**приватное поле, хранящее список детей текущего узла.*/
    private List<Node<T>> children;

    /**конструктор класса, принимающий данные для создания узла.
     * Создает новый объект с переданными данными и
     * инициализирует пустой список дочерних узлов.*/
    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    /**метод, возвращающий данные узла.*/
    public T getData() {
        return data;
    }

    /** метод, устанавливающий переданные данные как данные узла.*/
    public void setData(T data) {
        this.data = data;
    }

    /**метод, возвращающий список дочерних узлов текущего узла.*/
    public List<Node<T>> getChildren() {
        return children;
    }

    /**метод, устанавливающий переданный список
     * дочерних узлов как список дочерних узлов текущего узла.*/
    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    /**метод, добавляющий переданный узел в список дочерних узлов текущего узла.*/
    public void addChild(Node<T> child) {
        children.add(child);
    }

    /**Это основной метод удаления листового узла из дерева.
     * В качестве аргумента принимает листовой узел.*/
    public void removeLeaf(Node<T> leaf) {
        if (leaf == null) {
            throw new IllegalArgumentException("Leaf cannot be null");
        }

        if (leaf.getData().equals(data)) {
            throw new IllegalArgumentException("Cannot remove root node");
        }

        Node<T> parent = findParent(this, leaf);
        if (parent == null) {
            throw new IllegalArgumentException("Node is not part of the tree");
        }

        parent.getChildren().remove(leaf);
    }

    /**Это вспомогательный метод, используемый методом RemoveLeaf
     * для поиска родительского узла targetNode в дереве.*/
    private Node<T> findParent(Node<T> currentNode, Node<T> targetNode) {
        if (currentNode == null || currentNode.getChildren() == null) {
            return null;
        }

        for (Node<T> child : currentNode.getChildren()) {
            if (child.getData().equals(targetNode.getData())) {
                return currentNode;
            }

            Node<T> parent = findParent(child, targetNode);
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }

    /**сравнивает текущий узел с переданным объектом.
     * Если объекты равны по ссылке, возвращает true. Если переданный объект равен null
     * или не является экземпляром класса Node, возвращает false. Если переданный объект
     * является экземпляром класса Node, приводит его к типу и сравнивает данные и
     * списки дочерних узлов текущего узла с данными и списками дочерних узлов переданного узла,
     * используя методы equals класса Objects. Возвращает результат сравнения.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node<?> other = (Node<?>) obj;
        return Objects.equals(data, other.data) && Objects.equals(children, other.children);
    }
}

/**класс, который реализует интерфейс Iterable<Node<T>>. Он позволяет
 * создать итератор для обхода узлов дерева в порядке BFS.*/
class TreeIterableBFS<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
    private Node<T> root;

    public TreeIterableBFS(Node<T> root) {
        this.root = root;
    }

    /**метод, переопределенный из интерфейса Iterable,
     * который создает и возвращает новый объект BreadthFirstIterator,
     * который будет использоваться для итерации по дереву.*/
    @Override
    public Iterator<Node<T>> iterator() {
        return new BreadthFirstIterator(root);
    }


/**это вложенный класс, который реализует интерфейс
 * Iterator<Node<T>>. Он реализует итерацию по узлам дерева в порядке BFS.*/
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
/**класс, который реализует интерфейс Iterable<Node<T>>. Он позволяет
 * создать итератор для обхода узлов дерева в порядке DFS.*/
class TreeIterableDFS<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
    private Node<T> root;

    /** реализует интерфейс Iterable<Node<T>>, поэтому он должен предоставить реализацию метода iterator().*/
    public TreeIterableDFS(Node<T> root) {
        this.root = root;
    }

    /** создает новый объект DepthFirstIterator, который будет использоваться для итерации по дереву.*/
    @Override
    public Iterator<Node<T>> iterator() {
        return new DepthFirstIterator();
    }
    /**реализует интерфейс Iterator<Node<T>> и предоставляет методы для итерации по дереву в глубоком порядке.*/
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