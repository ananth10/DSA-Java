package com.example.myapplication.codingminutes_levelup.lru_cache;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LruCache {

    private class Node {
        String key;
        int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int maxSize;
    private LinkedList<Node> list;
    private Map<String, Node> map;

    public LruCache(int maxSize) {
        this.maxSize = Math.max(maxSize, 1);
        list = new LinkedList<>();
        map = new HashMap<>();
    }


    void insertKeyValue(String key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
        } else {
            if (list.size() == maxSize) {
                list.remove(list.size() - 1);
                map.remove(key);
            }
            Node n = new Node(key, value);
            list.addFirst(n);
            map.put(key, list.peek());
        }
    }

    String getMostRecent() {
        if (list != null && list.peek() != null) {
            return list.peek().key;
        }
        return "";
    }

    Node getValue(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.addFirst(new Node(node.key, node.value));
            list.remove(node);
            map.put(key, list.peek());
            return list.peek();
        }
        return null;
    }
}
