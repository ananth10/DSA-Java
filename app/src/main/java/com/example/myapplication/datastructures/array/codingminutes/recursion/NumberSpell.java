package com.example.myapplication.datastructures.array.codingminutes.recursion;

public class NumberSpell {

    public static String[] spells = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static void main(String[] args){
        numberSpell(2020);
    }

    static void numberSpell(int number){
        //base case
        if(number==0){
            return;
        }
       int last_digit = number%10;
       numberSpell(number/10);
       System.out.println(spells[last_digit]);
    }
}
