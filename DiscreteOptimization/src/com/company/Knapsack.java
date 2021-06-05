package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Item{
    
    float weight;
    int value;    
    int idx;
    
    public Item(){}
    public Item(int value, float weight, int idx){
        this.value = value;
        this.weight = weight;
        this.idx = idx;
    }
    
}

class Node{
    
    float upperBound;
    float lowerBound;
    float totalValue;
    float totalWeight;
    int level;    
    boolean isSelected;
    
    public Node(){}
    public Node(Node cpy){
        
        this.upperBound = cpy.upperBound;
        this.lowerBound = cpy.lowerBound;
        this.totalValue = cpy.totalValue;
        this.totalWeight = cpy.totalWeight;;
        this.isSelected = cpy.isSelected;
        this.level = cpy.level;
        
    }
    
}

//to sort based on lower bound
class SortByLowerBound implements Comparator<Node>{

    @Override
    public int compare(Node o1, Node o2) {
        
        boolean temp = o1.lowerBound > o2.lowerBound;
        return temp ? 1 : -1;
        
    }
    
}

class SortByRatio implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2) {
        
        boolean temp = (float)o1.value / (float)o1.weight > (float)o2.value / (float)o2.weight; 
        
        return temp ? -1 : 1;
    }
}

public class Knapsack {

    private static int size;
    private static float capacity;

    // Function to calculate upper bound
    // (includes fractional part of the items)
    static float getUpperBound(float tWeight, float tValue, int idx, Item[] arr){
        
        float value = tValue;
        float weight = tWeight;
        
        for (int i = idx; i < arr.length; i++){
            
            if(weight + arr[i].weight <= capacity){
                
                weight += arr[i].weight;
                value -= arr[i].value;
                
            }else{
                
                value -= (float)(capacity - weight) / arr[i].weight * arr[i].value;
                break;
                
            }
            
        }
        
        return value;
        
    }

    // Calculate lower bound (doesn't
    // include fractional part of items)
    static float getLowerBound(float tWeight, float tValue, int idx, Item[] arr){

        float value = tValue;
        float weight = tWeight;

        for (int i = idx; i < arr.length; i++){

            if(weight + arr[i].weight <= capacity){

                weight += arr[i].weight;
                value -= arr[i].value;

            }else{

                break;
            }

        }

        return value;

    }
    
    static void assign(Node temp, float uBound, float lBound, float tValue, 
                       float tWeight, boolean flag, int curLevel){
        
        temp.upperBound = uBound;
        temp.lowerBound = lBound;
        temp.totalWeight = tWeight;
        temp.totalValue = tValue;
        temp.isSelected = flag;
        temp.level = curLevel;        
        
    }
    
    
    public static void solve(Item[] arr){
        
        //sort items based on profit/weight ratio
        Arrays.sort(arr, new SortByRatio());
        
        Node current, left, right;
        current = new Node();
        left = new Node();
        right = new Node();
        
        // minimum lower bound of all explored nodes
        float minimumLowerBound = 0;
        
        // minimum lower bound of all paths that reached the final level
        float finalLowerBound = Integer.MAX_VALUE;
                
        current.totalValue = current.totalWeight = current.upperBound = current.lowerBound = 0;
        current.level = 0;
        current.isSelected = false;
        
        // priority queue to store elements based on lower bounds
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new SortByLowerBound());
        
        // have to insert a dummy node first -> root == 0,0,0,0,0
        priorityQueue.add(current);
        
        // to store at every index if the element is included or not
        boolean[] currentPath = new boolean[size];
        
        // to store result of selection when reached last level
        boolean[] finalPath = new boolean[size];
        
        while(!priorityQueue.isEmpty()){
            
            current = priorityQueue.poll();

            // if the current node's best case
            // value is not optimal than minLB,
            // then there is no reason to
            // explore that node. Including
            // finalLB eliminates all those
            // paths whose best values is equal
            // to the finalLB
            if(current.lowerBound > minimumLowerBound 
                    || current.upperBound >= finalLowerBound){
                
                continue;
                
            }
            
            if(current.lowerBound != 0) currentPath[current.level - 1] = current.isSelected;
            
            if(current.level == size){
                
                if(current.lowerBound < finalLowerBound){
                    
                    // reached last level
                    for(int i = 0; i < size; i++){
                        
                        finalPath[arr[i].idx] = currentPath[i];
                        finalLowerBound = current.lowerBound;
                        
                    }
                   
                }
                continue;
                
            }
            
            int level = current.level;
            
            // right node -. excludes current item
            assign(right, getUpperBound(current.totalWeight, current.totalValue, level + 1, arr), 
                    getLowerBound(current.totalWeight, current.totalValue, level + 1, arr), current.totalValue,
                    current.totalWeight,false, level + 1);

            if(current.totalWeight + arr[current.level].weight <= capacity){
                
                // left node -> includes current item
                left.upperBound = getUpperBound(current.totalWeight + arr[level].weight,
                        current.totalValue - arr[level].value,
                        level + 1, arr);
                
                left.lowerBound = getLowerBound(current.totalWeight + arr[level].weight,
                        current.totalValue - arr[level].value,
                        level + 1, arr);

                assign(left, left.upperBound, left.lowerBound, 
                        current.totalValue - arr[level].value,
                        current.totalWeight+ arr[level].weight,
                        true, level + 1);
                
                                
            }else{ // if left node cannot be inserted
                
                // stops left node from being inserted into queue
                left.upperBound = left.lowerBound = 1;
         
            }

            minimumLowerBound = Math.min(minimumLowerBound, left.lowerBound);
            minimumLowerBound = Math.min(minimumLowerBound, right.lowerBound);
            
            if(minimumLowerBound >= left.upperBound){
                priorityQueue.add(new Node(left));
            }
            if(minimumLowerBound >= right.upperBound){
                priorityQueue.add(new Node(right));
            }
      
        }

        System.out.println("Items taken into knapsack are: ");
        for (int i = 0; i < size; i++){
            if(finalPath[i])
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }

        System.out.println("\nMaximum profit: " + (-finalLowerBound));
        
    }
    
    
    public static void main(String[] args) {

        size = 4;
        capacity = 15;

        Item arr[] = new Item[size];
        arr[0] = new Item(10, 2, 0);
        arr[1] = new Item(10, 4, 1);
        arr[2] = new Item(12, 6, 2);
        arr[3] = new Item(18, 9, 3);

        solve(arr);
        
    }
    
}
