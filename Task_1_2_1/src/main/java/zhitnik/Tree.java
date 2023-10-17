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