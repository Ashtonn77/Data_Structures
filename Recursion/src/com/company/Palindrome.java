package com.company;

public class Palindrome {

    public boolean isPalindrome(String str){

        int _l = str.length();
        if(_l <= 1) return true;

        if(str.charAt(0) == str.charAt(_l - 1))
            return isPalindrome(str.substring(1, _l - 1));

        return false;

    }

}
