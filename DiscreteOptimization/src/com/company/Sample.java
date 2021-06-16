//package com.company;
//
//
//import javax.xml.crypto.dsig.keyinfo.PGPData;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class Sample {
//
//   private static int capacity;
//
//   private static float getProfit(int w, int v, int idx, Item[] items){
//
//       int weight = w;
//       int value = v;
//
//       for (Item item : items) {
//
//           if (weight + item.weight <= capacity) {
//
//               weight += item.weight;
//               value += item.value;
//
//           } else {
//
//               break;
//
//           }
//
//
//       }
//
//       return value;
//
//   }
//
//    private static float getBound(int w, float v, int idx, Item[] items){
//
//        int weight = w;
//        float value = v;
//
//        for(int i = idx; i < items.length; i++){
//
//            if(weight + items[i].weight <= capacity){
//
//                weight += items[i].weight;
//                value += items[i].value;
//
//            }else{
//
//                value += (capacity - weight) * ((float)items[i].value / (float)items[i].weight);
//
//            }
//
//
//        }
//
//        return value;
//
//    }
//
//
//    private static float solve(Item[] arr){
//
//        PriorityQueue<Node> pq = new PriorityQueue<>(new SortByBound());
//        int maxProfit = 0;
//
//        pq.add(new Node(0, 0, 0));
//        int level = 0;
//
//        while(!pq.isEmpty()){
//
//            int size = pq.size();
//
//            for(int i = 0; i < size; i++){
//
//                Node current = pq.poll();
//
//                int profit = current.profit;
//                int weight = current.weight;
//                float bound = current.bound;
//
//                if(bound <= profit)
//                    continue;
//
//                if(profit > maxProfit)
//                    maxProfit = profit;
//
//
//                //left
//                float profit_sub = getProfit(weight, profit, level, arr);
//                float bound_sub = getBound(weight + arr[level].weight, bound, level, arr);
//
//
//                //right
//
//
//            }
//
//
//        }
//
//
//        return 0;
//
//    }
//
//    public static void main(String[] args) {
//
//        int size = 4;
//        int capacity = 11;
//
//        Item arr[] = new Item[size];
//        arr[0] = new Item(4, 3, 0);
//        arr[1] = new Item(10, 5, 1);
//        arr[2] = new Item(8, 4, 2);
//        arr[3] = new Item(15, 8, 3);
//
//        System.out.println(solve(arr));
//
//    }
//
//}
//
//
//class Node{
//
//    int profit;
//    int weight;
//    float bound;
//
//    public Node(int profit, int weight, float bound){
//        this.profit = profit;
//        this.weight = weight;
//        this.bound = bound;
//    }
//
//}
//
//
//class Item{
//
//    int idx;
//    int weight;
//    int value;
//
//    public Item(int idx, int weight, int value){
//
//        this.idx = idx;
//        this.weight = weight;
//        this.value = value;
//
//    }
//
//}
//
//class SortByRation implements Comparator<Item>{
//    @Override
//    public int compare(Item o1, Item o2) {
//        return (int)((float)o2.value / (float)o2.weight - (float)o1.value / (float)o1.weight);
//    }
//}
//
//class SortByBound implements Comparator<Node>{
//
//    @Override
//    public int compare(Node o1, Node o2) {
//        return (int)(o2.bound - o1.bound);
//    }
//}