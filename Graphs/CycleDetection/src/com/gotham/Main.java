package com.gotham;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	
        Vertex vertex_1 = new Vertex("1");
        Vertex vertex_2 = new Vertex("2");
        Vertex vertex_3 = new Vertex("3");
        Vertex vertex_4 = new Vertex("4");
        Vertex vertex_5 = new Vertex("5");
        Vertex vertex_6 = new Vertex("6");
        
        
        vertex_1.addNeighbour(vertex_2);
        vertex_2.addNeighbour(vertex_3);
        vertex_1.addNeighbour(vertex_3);
        vertex_4.addNeighbour(vertex_1);
        vertex_4.addNeighbour(vertex_5);
        vertex_5.addNeighbour(vertex_6);
        vertex_6.addNeighbour(vertex_4);

        List<Vertex> adjacencyList = new ArrayList<>();
        adjacencyList.add(vertex_1);
        adjacencyList.add(vertex_2);
        adjacencyList.add(vertex_3);
        adjacencyList.add(vertex_4);
        adjacencyList.add(vertex_5);
        adjacencyList.add(vertex_6);
        
        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detectCycle(adjacencyList);
        
        
    }
}
