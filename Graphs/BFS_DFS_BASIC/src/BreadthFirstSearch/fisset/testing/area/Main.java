package BreadthFirstSearch.fisset.testing.area;

public class Main {

    public static void main(String[] args) {

       BFS bfs = new BFS();

        Vertex vertex_1 = new Vertex(1);
        Vertex vertex_2 = new Vertex(2);
        Vertex vertex_3 = new Vertex(3);
        Vertex vertex_4 = new Vertex(4);
        Vertex vertex_5 = new Vertex(5);

        vertex_1.addNeighbour(vertex_2);
        vertex_1.addNeighbour(vertex_4);
        vertex_4.addNeighbour(vertex_3);
        vertex_2.addNeighbour(vertex_5);
        vertex_3.addNeighbour(vertex_5);

        System.out.println(bfs.bfs(vertex_1, vertex_5));
        
    }
}
