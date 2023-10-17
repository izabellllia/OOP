package zhitnik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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