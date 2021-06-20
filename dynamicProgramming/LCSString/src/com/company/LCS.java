package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCS {

    int findLength(String x, String y, int m, int n, int[][] res){
        
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++){
                
                char a = x.charAt(i - 1);
                char b = y.charAt(j - 1);
                
                if(a == b)                    
                    res[i][j] = res[i - 1][j - 1] + 1;                                        
                else
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                
            }
               
        return res[m][n];
        
    }
    
    String findString(String x, String y, int m, int n, int[][] res){
        
        if(m == 0 || n == 0)
            return "";
        
        if(x.charAt(m - 1) == y.charAt(n - 1))
            return findString(x, y, m - 1, n - 1, res) + x.charAt(m - 1);
        
        if(res[m - 1][n] > res[m][n - 1])
            return findString(x, y, m - 1, n, res);
        else
            return findString(x, y, m, n - 1, res);
        
        
    }
    
    List<String> findAllStrings(String x, String y, int m, int n, int[][] res){
        
        if(m == 0 || n == 0){

            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
            
        }
        
        if(x.charAt(m - 1) == y.charAt(n - 1)){
            
            List<String> lcs = findAllStrings(x, y, m - 1, n - 1, res); 
            
            for(int i = 0; i < lcs.size(); i++)
                lcs.set(i, lcs.get(i) + (x.charAt(m - 1)));
            
            return lcs;
            
        }
        
        if(res[m - 1][n] > res[m][n - 1])
            return findAllStrings(x, y, m - 1, n, res);
        
        if(res[m][n - 1] > res[m - 1][n])
            return findAllStrings(x, y, m, n - 1, res);
        
        List<String> top = findAllStrings(x, y, m - 1, n, res);
        List<String> left = findAllStrings(x, y, m, n - 1, res);
        
        top.addAll(left);        
        return top;
        
    }
   
}
