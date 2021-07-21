package com.company;

public class ReverseString {

    public String reverseString(String temp){

        int _l = temp.length();
        if(_l == 0) return "";

        return reverseString(temp.substring(1)) + temp.charAt(0);

    }


}
