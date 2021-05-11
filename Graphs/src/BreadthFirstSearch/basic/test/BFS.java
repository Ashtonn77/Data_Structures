package BreadthFirstSearch.basic.test;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    public void bfs(Vertex root){

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        
        while(!queue.isEmpty()){
            
            Vertex current = queue.remove();
            System.out.println(current + "");
            
            for(Vertex child : current.getNeighbours()){
                
                if(!child.isVisited()){
                  
                    queue.add(child);
                    child.setVisited(true);
                    
                }
                
            }      
            
        }
        
        
    }
    
    
}
