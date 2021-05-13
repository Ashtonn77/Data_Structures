package DepthFirstSearch.recursive;

import java.util.List;

public class DFS {
    
    public void dfs(List<Vertex> vertexList){
        
        for (Vertex vertex : vertexList){
            
            if(!vertex.isVisited()){
                
                vertex.setVisited(true);
                dfsWithRecursion(vertex);
                
            }
            
        }
        
        
    }

    private void dfsWithRecursion(Vertex vertex) {

        System.out.print(vertex + " ");
        
        for (Vertex child : vertex.getNeighboursList()){
            
            if(!child.isVisited()){
                
                child.setVisited(true);
                dfsWithRecursion(child);
                
            }
            
        }
        
    }

}
