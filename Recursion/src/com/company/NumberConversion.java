package com.company;

public class NumberConversion {

    public String convertBase10ToBase2(int number, String result){

        if(number == 0)
            return result;

        result = number % 2 + result;

        return convertBase10ToBase2(number / 2, result);

    }


}
