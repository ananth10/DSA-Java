package com.example.myapplication.codingminutes_levelup.lru_cache;

public class LruMain {
    public static void main(String[] args){
        LruCache lruCache = new LruCache(3);
        lruCache.insertKeyValue("Mango",10);
        lruCache.insertKeyValue("Apple",20);
        lruCache.insertKeyValue("Orange",30);
        System.out.println("Most Recent Key:"+lruCache.getMostRecent());

        lruCache.insertKeyValue("Mango",40);
        System.out.println("Most Recent Key:"+lruCache.getMostRecent());

        lruCache.insertKeyValue("Banana",50);
        System.out.println("Most Recent Key:"+lruCache.getMostRecent());
    }
}
