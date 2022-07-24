package com.my.demo.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity=10;
    Node head;
    Node tail;
    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,Node> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node=map.get(key);
        if (node==null){
            return -1;
        }
        if (head!=null&&head==node){
            return node.value;
        }
        Node curPre=node.pre;
        Node curNext=node.next;
        Node h=head;
        head=node;
        head.next=h;
        head.pre=null;
        if (h!=null){
            h.pre=node;
        }
        if (curPre!=null){
            curPre.next=curNext;
        }
        if (curNext!=null){
            curNext.pre=curPre;
        }
        if (curNext==null&&curPre!=null){
            tail=curPre;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node=null;
        if (map.containsKey(key)){
            node=map.get(key);
            node.value=value;
        }else{
            node=new Node(key,value);
            if (map.size()>=capacity){
                map.remove(tail.key);
                Node tailPre=tail.pre;
                if (tailPre!=null){
                    tailPre.next=null;
                    tail=tailPre;
                }else{
                    tail=node;
                }
            }

        }

        if (head!=null&&head==node){
            map.put(key,node);
            return;
        }

        Node curPre=node.pre;
        Node curNext=node.next;
        Node h=head;
        head=node;
        head.next=h;
        head.pre=null;

        if (h==null){
            tail=node;
        }else{
            h.pre=node;
        }
        if (curPre!=null){
            curPre.next=curNext;
        }
        if (curNext!=null){
            curNext.pre=curPre;
        }
        if (curNext==null&&curPre!=null){
            tail=curPre;
        }
        map.put(key,node);
    }
}
