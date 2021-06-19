package com.company;

import java.util.Map;

public class LCSRecursiveMemoization {
    
    int findLCS(String x, String y, int m, int n, Map<String, Integer> memo){
      
        if(m == 0 || n == 0) return 0;
        
        String key = m + "**" + n;
        
        if(!memo.containsKey(key)){

            if(x.charAt(m - 1) == y.charAt(n - 1))
                return findLCS(x, y, m - 1, n - 1, memo) + 1;
            else
                memo.put(key, Math.max(findLCS(x, y, m - 1, n, memo), findLCS(x, y, m, n - 1, memo)));

        }
        
        return memo.get(key);
        
    }
    
}
