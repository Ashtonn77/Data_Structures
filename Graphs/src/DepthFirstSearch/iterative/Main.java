package DepthFirstSearch.iterative;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Vertex vertex_1 = new Vertex("1");
        Vertex vertex_2 = new Vertex("2");
        Vertex vertex_3 = new Vertex("3");
        Vertex vertex_4 = new Vertex("4");
        Vertex vertex_5 = new Vertex("5");
        
        
        vertex_1.addNeighbour(vertex_2);
        vertex_1.addNeighbour(vertex_3);
        vertex_3.addNeighbour(vertex_4);
        vertex_4.addNeighbour(vertex_5);

        List<Vertex> vertexList = new ArrayList<>();
        
        vertexList.add(vertex_1);
        vertexList.add(vertex_2);
        vertexList.add(vertex_3);
        vertexList.add(vertex_4);
        vertexList.add(vertex_5);
        
        
        DFS dfs = new DFS();
        dfs.dfs(vertexList);
        
    }
    
}
