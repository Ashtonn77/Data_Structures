package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String x = "XMJYAUZ";
        String y = "MZJAWXU";
        int m = x.length();
        int n = y.length();
        
       // System.out.println(new LCSRecursive().findLCS(x, y, m, n));
       // System.out.println(new LCSRecursiveMemoization().findLCS(x, y, m, n, new HashMap<>()));
        System.out.println(new LCSBottomUp().findLCS(x, y, m, n));
        
    }
    
}
