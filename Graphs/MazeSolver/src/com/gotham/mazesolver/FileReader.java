package com.gotham.mazesolver;

import java.io.File;
import java.util.Scanner;

public class FileReader {
    
    private int[][] map;
    private String fileName;
    private int numberOfRows;
    private int numberOfColumns;
    private int startPositionRow;
    private int startPositionColumn;

    public FileReader(String fileName, int numberOfRows, int numberOfColumns) {
        this.fileName = fileName;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = new int[numberOfRows][numberOfColumns];
    }
    
    public void parseFile(){
        
        try{

            Scanner scanner = new Scanner(new File(this.fileName));
            
            for(int i = 0; i < this.numberOfRows; i++){
                
                for(int j = 0; j < this.numberOfColumns; j++){
                    
                    if(scanner.hasNext()){
                        this.map[i][j] = scanner.nextInt();
                    }
                    
                    if(this.map[i][j] == 2){
                        this.startPositionColumn = j;
                        this.startPositionRow = i;   
                    }
                    
                }                
                
            }
            
            scanner.close();
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
    }

    public int[][] getMap() {
        return map;
    }

    public int getStartPositionRow() {
        return startPositionRow;
    }

    public int getStartPositionColumn() {
        return startPositionColumn;
    }
    
}
