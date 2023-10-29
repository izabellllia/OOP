package zhitnik;

public class Edge<T> {
    private Vertex<T> start;
    private Vertex<T> end;
    private int weight;
    private T data;

    public Edge(Vertex<T> start, Vertex<T> end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Vertex<T> getStart() {
        return start;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}