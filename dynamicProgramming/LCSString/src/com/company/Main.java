package com.company;


public class Main {

    public static void main(String[] args) {
	
        String x = "ABCBDAB";
        String y = "BDCABA";
        int m = x.length();
        int n = y.length();

        int[][] res = new int[m + 1][n + 1];
        
        System.out.println(new LCS().findLength(x, y, m, n, res));
        System.out.println(new LCS().findString(x, y, m, n, res));
        System.out.println(new LCS().findAllStrings(x, y, m, n, res));
        
    }
    
}
