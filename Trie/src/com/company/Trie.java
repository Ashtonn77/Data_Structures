package com.company;

public class Trie {

    private Node root;
    
    public Trie(){
        this.root = new Node('\0');
    }
    
    public void insert(String word){
        
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new Node(c);
            
            cur = cur.children[c - 'a'];
            
        }
        
        cur.isWord = true;
        
    }
    
    public boolean search(String word){
        
        Node cur = getNode(word);
        return cur != null && cur.isWord;
        
    }
    
    public boolean startaWith(String prefix){
        
        return getNode(prefix) != null;
        
    }
    
    private Node getNode(String word){
        
        Node cur = root;
        
        for(int i = 0; i < word.length(); i++){
            
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null)
                return null;
            cur = cur.children[c - 'a'];
            
        }
        
        return cur;
        
    }
    
}

class Node{
    
    char c;
    boolean isWord;
    Node[] children;
    
    public Node(char c){
        
        this.c = c;
        isWord = false;
        children = new Node[26];
        
    }    
    
}