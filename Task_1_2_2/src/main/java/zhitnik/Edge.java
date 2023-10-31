package zhitnik;

/**класс, который представляет ребро графа.*/
public class Edge<T> {
    private Vertex<T> start;
    private Vertex<T> end;
    private int weight;
    private T data;

    /**конструктор класса, который принимает начальную и конечную вершины.*/
    public Edge(Vertex<T> start, Vertex<T> end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    /**возвращает начальную вершину.*/
    public Vertex<T> getStart() {
        return start;
    }

    /**возвращает конечную вершину.*/
    public Vertex<T> getEnd() {
        return end;
    }

    /**возвращает вес ребра.*/
    public int getWeight() {
        return weight;
    }

    /**возвращает данные ребра.*/
    public T getData() {
        return data;
    }

    /**устанавливает данные ребра.*/
    public void setData(T data) {
        this.data = data;
    }
}