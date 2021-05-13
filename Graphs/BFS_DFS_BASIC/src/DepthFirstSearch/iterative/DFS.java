package DepthFirstSearch.iterative;

import java.util.List;
import java.util.Stack;

public class DFS {
    
    private Stack<Vertex> stack;
    
    public DFS(){
        stack = new Stack<>();
    }
    
    public void dfs(List<Vertex> vertexList){
        
        for(Vertex vertex : vertexList){
            
            if(!vertex.isVisited()){
                
                vertex.setVisited(true);
                dfsWithStack(vertex);
                
            }
            
        }
        
    }

    private void dfsWithStack(Vertex vertex) {
            
        this.stack.add(vertex);
        vertex.setVisited(true);
        
        while(!stack.isEmpty()){
            
            Vertex currentVertex = this.stack.pop();
            System.out.print(currentVertex + " ");
            
            for(Vertex child : currentVertex.getNeighboursList()){
                
                
                if(!child.isVisited()){
                    
                    child.setVisited(true);
                    stack.add(child);
                    
                }
                
            }
            
            
        }
        
        
    }

}
