package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Modulo Exponentiation
 * ---------------------
 *
 * You are given two numbers a and b, your task is to compute a raised to power b.
 *
 * As this value can be very large compute it to modulo 1000000007.
 *
 * HINT : Use Modulo Properties
 *
 * (m * n) % p has a very interesting property:
 * (m * n) % p =((m % p) * (n % p)) % p
 * Expected Time Complexity:
 *
 * O(log b)
 *
 * Input Format:
 *
 * In the function, 2 integers a and b are passed.
 *
 * Output Format:
 *
 * Return a single integer which is equivalent to (a^b) modulo 1000000007.
 *
 * Constraints:
 * 1<=a,b<=50
 * Sample Testcase:
 * Input:
 * 5 3
 * Output:
 * 125
 * */
public class ModuloExponentiation {

    public static void main(String[] args){
      int a = 5;
      int b = 3;
      long mod = (long) (1e9+7);
      long result = solve(a,b,mod);
        System.out.println("Result: "+ result);
    }

    static long solve(int a,int b,long mod){
        //base case
        if(a==0) return 0;
        if(b==0) return 1;

        long res;

        if((b&1) !=0){ //check whether power is odd or not. if odd means a*a^b-1 and even means (a2)^b/2
           res = a % mod;
           res = (res*solve(a,b-1,mod) % mod) % mod;
        }else{
            res = solve(a,b/2,mod);
            res = (res * res) % mod;
        }
     return ((res+mod) % mod);
    }
}
