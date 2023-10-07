package zhitnik;

import java.util.*;

class Tree<T> {
    private Node<T> root;

    public Tree(T data) {
        this.root = new Node<>(data);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getHeight() {
        return getHeight(root);
    }

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
}

class Node<T> {
    private T data;
    private List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public void addChild(Node<T> child) {
        children.add(child);
    }

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

class BreadthFirstIterator<T> implements Iterable<Node<T>> {
    private Node<T> root;

    public BreadthFirstIterator(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<Node<T>>() {
            private Queue<Node<T>> queue = new LinkedList<>();

            {
                queue.add(root);
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

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


