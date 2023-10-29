package zhitnik;

public class Vertex<T> {
    private T data;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
