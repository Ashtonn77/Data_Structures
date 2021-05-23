package com.gotham.mazesolver;

public class MazeSolver {
    
    private int[][] mazeMap;
    private boolean[][] visited;
    private int startPositionRow;
    private int startPositionColumn;

    public MazeSolver(int[][] mazeMap, int startPositionRow, int startPositionColumn) {
        this.mazeMap = mazeMap;
        this.startPositionRow = startPositionRow;
        this.startPositionColumn = startPositionColumn;
        
        //if mazeMap map size is 0 - will throw exception
        this.visited = new boolean[mazeMap.length][mazeMap[0].length];
    }
    
    public void findWayOut(){
        
        try {
            
            dfs(this.startPositionRow, this.startPositionColumn);
            System.out.println("Unable to find route to exit");
            
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }

    private void dfs(int rowIndex, int columnIndex) {

        System.out.println("Visiting row: " + rowIndex + ", column: " + columnIndex);
        
        if(this.mazeMap[rowIndex][columnIndex] == 3) {
            throw new RuntimeException("Route to exit found successfully at: " + rowIndex + ", " + columnIndex);
        }

        int endOfRow = this.mazeMap.length-1;
        int endOfColumn = this.mazeMap[rowIndex].length-1;

        System.out.println(endOfRow + "::" + endOfColumn);
        
        if(this.visited[rowIndex][columnIndex]) {
            return;
        } else if(rowIndex < 0 || rowIndex > endOfRow) {
            return;
        } else if (columnIndex < 0 || columnIndex > endOfColumn) {
            return;
        } else if(this.mazeMap[rowIndex][columnIndex] == 1) {
            return;
        } else {
            
            this.visited[rowIndex][columnIndex] = true;

            dfs(rowIndex + 1, columnIndex);
            dfs(rowIndex, columnIndex + 1);
            dfs(rowIndex, columnIndex - 1);
            dfs(rowIndex - 1, columnIndex);
            
        }
    }

}
