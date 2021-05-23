package com.gotham.mazesolver;

public class App {

    public static void main(String[] args) {
        
        FileReader fileReader = new FileReader("/home/ash/Documents/github/Data_Structures/Graphs/MazeSolver/src/map", 
                7, 7);
        fileReader.parseFile();
        MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionColumn());
        mazeSolver.findWayOut();
        
    }
    
}
