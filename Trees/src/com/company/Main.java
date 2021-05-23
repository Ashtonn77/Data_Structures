package com.company;

public class Main {

    public static void main(String[] args) {
	
        BST bst = new BST();
      
        bst.insert(5);
        bst.insert(15);
        bst.insert(4);
        bst.insert(14);
        bst.insert(18);
        bst.insert(3);

        Node root = bst.getRoot();
        System.out.println(bst.lookUp(144));
        bst.traverse(root);
        System.out.println(bst.remove(14) + "::");
        bst.traverse(root);
        
    }
}
