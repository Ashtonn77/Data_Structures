package com.company;

public class LCSRecursive {
    
    int findLCS(String x, String y, int m, int n){
        
        if(m == 0 || n == 0) return 0;
        
        if(x.charAt(m - 1) == y.charAt(n - 1))
            return findLCS(x, y, m - 1, n - 1) + 1;
        
        return Math.max(findLCS(x, y, m - 1, n), findLCS(x, y, m, n - 1));        
        
    }
    
}
