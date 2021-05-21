package com.example.backdemo.leetcode.algorithm_146;


import java.util.HashMap;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-20 11:22
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 **/
public class LRUCache {
    int size;
    int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer,Node> hashnode=new HashMap<>();

    public static class Node{
        private Node next;
        private Node prev;
        private int key;
        private int data;
        public Node(int key,int data){
            this.key = key;
            this.data = data;
        }

        public int get(){
            return data;
        }
        public void set(int data){
            this.data=data;
        }
        public int getkey(){
            return key;
        }
        private Node(){}
    }
    public void changehead(Integer key){
        Node node=hashnode.get(key);
        if(head!=node){
            if(tail==node){
                //断尾
                tail=tail.prev;
                //接头
                node.next=head;
                head.prev=node;
                head=node;
            }else{
                //从链中移除
                node.next.prev=node.prev;
                node.prev.next=node.next;
                //接头
                head.prev=node;
                node.next=head;
                head=node;
            }
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        size=0;
    }
    public int get(int key) {
        if(hashnode.containsKey(key)){
            //System.out.println(1);
            changehead(key);
            return hashnode.get(key).get();
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(!hashnode.containsKey(key)){
            Node node=new Node(key,value);
            hashnode.put(key,node);
            if(size<capacity){
                if(size==0){
                    head=node;
                    tail=node;
                }else{
                    node.next=head;
                    head.prev=node;
                    head=node;
                }
                size++;
            }else{
                hashnode.remove(tail.getkey());
                //断尾
                tail=tail.prev;
                //接头
                node.next=head;
                head.prev=node;
                head=node;
            }
            //changehead(key);原本是都插入最后一个再changehead
        }else{
            hashnode.get(key).set(value);
            changehead(key);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
