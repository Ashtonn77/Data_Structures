package BreadthFirstSearch.fisset.testing.area;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int data;
    private boolean visited;
    List<Vertex> neighbours;

    public Vertex(int data) {
        this.data = data;
        neighbours = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Vertex> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Vertex vertex) {
        this.neighbours.add(vertex);
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
