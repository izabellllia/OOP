package zhitnik;

/**представление вершины графа.*/
public class Vertex<T> {
    private T data;

    /**конструктор, который принимает данные вершины.*/
    public Vertex(T data) {
        this.data = data;
    }

    /**возвращает данные вершины.*/
    public T getData() {
        return data;
    }

    /**устанавливает данные вершины.*/
    public void setData(T data) {
        this.data = data;
    }

    /** переопределенный метод для сравнения вершин по их данным.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }

    /**переопределенный метод для вычисления хэш-кода вершины на основе ее данных.*/
    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
