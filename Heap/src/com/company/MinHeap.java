package com.company;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    
    List<Integer> storage;
    public MinHeap(){
        storage = new ArrayList<>();
    }
    
    boolean isEmpty(){ return storage.size() <= 0; }
    
    private int getParentIdx(int idx){ return (idx - 1) / 2; }
    private int getLeftChildIdx(int idx){ return 2 * idx + 1; }
    private int getRightChildIdx(int idx){ return 2 * idx + 2; }
    
    private boolean hasParent(int idx){ return getParentIdx(idx) >= 0; }
    private boolean hasLeftChild(int idx){ return getLeftChildIdx(idx) < storage.size(); }
    private boolean hasRightChild(int idx){ return getRightChildIdx(idx) < storage.size(); }
    
    private int getParentElement(int idx){ return storage.get(getParentIdx(idx)); }
    private int getLeftChildElement(int idx){ return storage.get(this.getLeftChildIdx(idx)); }
    private int getRightChildElement(int idx){ return storage.get(this.getRightChildIdx(idx)); }
    
    void swap(int i, int j){
        
        int temp = storage.get(i);
        storage.set(i, storage.get(j));
        storage.set(j, temp);        
        
    }
    
    private void heapifyUp(){
        
        int idx = storage.size() - 1;
        while(hasParent(idx) && getParentElement(idx) > storage.get(idx)){
            swap(getParentIdx(idx), idx);
            idx = getParentIdx(idx);
        }
        
    }
    
    private void heapifyDown(){
        
        int idx = 0;
        while(hasLeftChild(idx)){
            
            int smallerChildIdx = getLeftChildIdx(idx);
            if(hasRightChild(idx) && getRightChildElement(idx) < getLeftChildElement(idx))
                smallerChildIdx = getRightChildIdx(idx);
            
            if(storage.get(idx) < storage.get(smallerChildIdx))
                break;
            else
                swap(idx, smallerChildIdx);
            
            idx = smallerChildIdx;
            
        }
        
    }
    
    void insert(int data){        
        storage.add(data);
        heapifyUp();        
    }
    
    int removeMin(){
        
        if(isEmpty()) return Integer.MIN_VALUE;
        
        int data = storage.remove(0);
        
        if(storage.size() > 0){

            int temp = storage.remove(storage.size() - 1);

            storage.add(0, temp);

            heapifyDown();
            
        }
        
        return data;
        
    }
    
    
}
