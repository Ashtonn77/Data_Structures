package TopologicalOrdering;

import java.util.Stack;

public class TopologicalOrdering {
    
    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }
    
    public void dfs(Vertex vertex){
        vertex.setVisited(true);
        
        for(Vertex child : vertex.getNeighborList()){
            
            if(!child.isVisited()){
                dfs(child);
            }
            
        }
        
        stack.push(vertex);
        
    }
    
    public Stack<Vertex> getStack(){
        return this.stack;
    }
    
    
}
