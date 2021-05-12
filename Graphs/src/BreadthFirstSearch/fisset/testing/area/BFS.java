package BreadthFirstSearch.fisset.testing.area;

import java.util.*;

public class BFS {
    
    public List<Vertex> bfs(Vertex start, Vertex end){
        
        Vertex[] prev = solve(start);
        
        return reconstruct(start, end, prev);
        
    }
    
    Vertex[] solve(Vertex start){
        
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(start);
        start.setVisited(true);
        
        Vertex[] prev = new Vertex[1000];
        
        while(!queue.isEmpty()){
            
            Vertex currentVertex = queue.remove();
            
            for(Vertex child : currentVertex.getNeighbours()){
                
                if(!child.isVisited()){
                    
                    queue.add(child);
                    child.setVisited(true);
                    prev[child.getData()] = currentVertex;
                    
                }
                
                
            }
            
        }
        
        return prev;
    }


    List<Vertex> reconstruct(Vertex start, Vertex end, Vertex[] prev){

        List<Vertex> path = new ArrayList<>();
        
        for(int i = end.getData(); prev[i] != null; i--){
            
            path.add(prev[i]);
            
        }

        Collections.reverse(path);
        
        if(path.get(0) == start)
            return path;
        
        return null;
        
    }
    

}
