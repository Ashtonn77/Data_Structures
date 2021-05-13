package com.gotham;

import java.util.List;

public class CycleDetection {
    
    public void detectCycle(List<Vertex> vertexList){
        
        for(Vertex vertex : vertexList){
            
            if(!vertex.isVisited()){
                dfs(vertex);
            }
            
        }
        
    }

    private void dfs(Vertex vertex) {

        System.out.println("DFS on vertex: " + vertex);
        
        vertex.setInStack(true);
        
        for(Vertex child : vertex.getAdjacencyList()){

            System.out.println("visiting neighbours of vertex: " + vertex);
            
            if(child.isInStack()){
                System.out.println("cycle detected: -> " + child);
                return;
            }
            
            if(!child.isVisited()){
                child.setVisited(true);
                dfs(child);
            }
            
        }
        
        vertex.setInStack(false);
        vertex.setVisited(true);
        
    }

}
