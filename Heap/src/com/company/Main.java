package com.company;

import java.rmi.Remote;

public class Main {
    
    public static void main(String[] args) {
	
        MinHeap heap = new MinHeap();

        heap.insert(100);
        heap.insert(50);
        heap.insert(40);
        heap.insert(5);
        heap.insert(200);
        heap.insert(35);

        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());
        System.out.println(heap.removeMin());

        System.out.println(heap.removeMin());
        
        System.out.println(heap.storage);
        
        
    }
    
}
