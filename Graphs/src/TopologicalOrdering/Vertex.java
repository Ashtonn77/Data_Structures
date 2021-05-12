package TopologicalOrdering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    
    private String data;
    private boolean visited;
    private List<Vertex> neighborList;

    public Vertex(String data) {
        this.data = data;
        this.neighborList = new ArrayList<>();
    }
    
    public void addNeighbour(Vertex vertex){
        this.neighborList.add(vertex);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
    }

    public void setNeighborList(List<Vertex> neighborList) {
        this.neighborList = neighborList;
    }

    @Override
    public String toString() {
        return this.data;
    }
}
