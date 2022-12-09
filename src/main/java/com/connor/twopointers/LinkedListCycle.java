package com.connor.twopointers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;

public class LinkedListCycle {

    public static class Node<T>{
        public Node(T val){
            this.val = val;
        }
        public T val;
        public Node<T> next;
    }

    public Node<Integer> deserializeList(String list){
        Iterator<String> itr = Arrays.stream(list.split(" ")).iterator();
        return buildList(itr, Integer::parseInt);
    }

    public Node<Integer> buildList(Iterator<String> itr, Function<String, Integer> f){
        Node<Integer> node = null;
        if(itr.hasNext()){
            node = new Node<>(f.apply(itr.next()));
            node.next = buildList(itr, Integer::parseInt);
        }
        return node;
    }

    public static boolean hasCycle(Node<Integer> nodes) {
        // WRITE YOUR BRILLIANT CODE HERE
        return false;
    }
}
