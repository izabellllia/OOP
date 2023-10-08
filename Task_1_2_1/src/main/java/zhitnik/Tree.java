package zhitnik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

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

    /**метод, устанавливающий переданный список дочерних узлов как список дочерних узлов текущего узла.*/
    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    /**метод, добавляющий переданный узел в список дочерних узлов текущего узла.*/
     public void addChild(Node<T> child) {
        children.add(child);
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

/**Реализует интерфейс Iterable, позволяя его использовать в цикле foreach.
 * Он принимает корневой узел в конструкторе и предоставляет итератор,
 * который выполняет обход дерева в ширину. Итератор использует очередь для отслеживания узлов,
 * которые нужно посетить следующими.*/
class BreadthFirstIterator<T> implements Iterable<Node<T>> {
    /**приватное поле, хранящее корневой узел дерева.*/
     private Node<T> root;
    /*конструктор класса, принимающий корневой узел дерева. Инициализирует поле root переданным узлом.*/
    public BreadthFirstIterator(Node<T> root) {
        this.root = root;
    }

    /**переопределенный метод iterator интерфейса Iterable. Создает и возвращает новый объект Iterator<Node<T>>,
     * который будет использоваться для итерации по дереву.*/
     @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            /**приватное поле, хранящее очередь узлов для обхода в ширину.*/
             private Queue<Node<T>> queue = new LinkedList<>();

            {
                queue.add(root);
            }

            /**переопределенный метод hasNext интерфейса Iterator. Возвращает true, если очередь не пуста
             * (есть еще узлы для обхода), и false в противном случае.*/
             @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }
            /**переопределенный метод next интерфейса Iterator. Возвращает следующий узел для обхода в ширину.
             * Если очередь пуста, генерируется исключение NoSuchElementException.
             * Иначе, извлекается первый узел из очереди, и для каждого дочернего узла текущего узла добавляется в
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
        };
    }
}
