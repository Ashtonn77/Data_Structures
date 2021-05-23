package com.company;

public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(int value) {

        Node newNode = new Node(value);

        if (this.root == null)
            this.root = newNode;
        else {

            Node currentNode = this.root;

            while (true) {

                if (value < currentNode.value) {

                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }

                    currentNode = currentNode.left;

                } else {

                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }

                    currentNode = currentNode.right;

                }

            }
        }
    }

    public int lookUp(int value) {

        if (this.root == null)
            return -1;

        Node currentNode = this.root;

        while (currentNode != null) {

            if (value < currentNode.value)
                currentNode = currentNode.left;
            else if (value > currentNode.value)
                currentNode = currentNode.right;
            else return currentNode.value;
        }

        return -1;
    }


    public void traverse(Node root) {

        if (root == null)
            return;

        if (root.left != null)
            traverse(root.left);

        System.out.println(root.value);

        if (root.right != null)
            traverse(root.right);

    }


    public boolean remove(int value) {

        if (this.root == null)
            return false;

        Node currentNode = this.root;
        Node parentNode = null;

        while (currentNode != null) {

            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {

                if (parentNode == null)
                    this.root = currentNode.left;
                else {

                    if (currentNode.right == null) {

                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right;
                        }

                    }else if(currentNode.right.left == null){                        
                        currentNode.right.left = currentNode.left;
                        if(parentNode == null){
                            this.root = currentNode.right;
                        }else{
                            
                            if(currentNode.value < parentNode.value){
                                parentNode.left = currentNode.right;
                            }else if(currentNode.value > parentNode.value){
                                parentNode.right = currentNode.right;
                            }
                            
                        }
                        
                    }else{
                        
                        Node leftMost = currentNode.right.left;
                        Node leftMostParent = currentNode.right;
                        
                        while(leftMost.left != null){
                            
                            leftMostParent = leftMost;
                            leftMost = leftMost.left;
                            
                        }
                        
                        leftMostParent.left = leftMost.right;
                        leftMost.left = currentNode.left;
                        leftMost.right = currentNode.right;
                        
                        if(parentNode == null)
                            this.root = leftMost;
                        else{
                            
                            if(currentNode.value < parentNode.value){
                                
                                parentNode.left = leftMost;
                                
                            }else if(currentNode.value > parentNode.value){
                                
                                parentNode.right = leftMost;
                                
                            }
                            
                        }
                        
                    }

                    return true;
                }


            }
            //end main if            
        }

        return false;

    }


}
