package com.company;

public class FenwickTree {

    int[] fenwick;
    
    //parent = i - (i & -i)
    void buildTree(int[] arr){

        int n = arr.length;
        fenwick = new int[n + 1];

        fenwick[1] = arr[0];

        for(int i  = 1; i < n; i++)
            fenwick[i + 1] = fenwick[i] + arr[i];


        for(int i = n; i > 0; i--){

            int parent = i - (i & -i);
            if(parent >= 0)
                fenwick[i] -= fenwick[parent];


        }

    }

    private int sum(int i){

        i++;
        int result = 0;

        while(i > 0){

            result += fenwick[i];
            i = i - (i & -i);

        }

        return result;

    }

    private void increment(int i, int val){
        
        int n = fenwick.length;
        i++;
        while(i <= n){

            fenwick[i] += val;
            i = i + (i & -i);

        }

    }
    
    
}
