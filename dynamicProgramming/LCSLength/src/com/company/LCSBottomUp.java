package com.company;

import java.util.Map;

public class LCSBottomUp {
    
    int findLCS(String x, String y, int m, int n){
        
        int[][] output = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++)
            
            for(int j = 1; j <= n; j++){
                
                char a = x.charAt(i - 1);
                char b = y.charAt(j - 1);
                
                if(a == b)
                    output[i][j] = output[i - 1][j - 1] + 1;
                else
                    output[i][j] = Math.max(output[i][j - 1], output[i - 1][j]);                
                
            }
        
        return output[m][n];
        
    }
    
}
