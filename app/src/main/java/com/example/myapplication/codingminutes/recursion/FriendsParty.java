package com.example.myapplication.codingminutes.recursion;

public class FriendsParty {


    public static void main(String[] args){
        int count = friendsParty(3);
        System.out.println(count);
    }
    static int  friendsParty(int n){
        if(n<=0)
            return 0;
        if(n==2 || n==1)
            return n;
        return friendsParty(n-1) + friendsParty(n-1)*friendsParty(n-2);
    }
}

