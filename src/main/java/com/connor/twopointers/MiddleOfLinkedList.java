package com.connor.twopointers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Function;

public class MiddleOfLinkedList {

    public static class Node<T>{
        public T val;
        public Node<T> next;

        public Node(T val, Node<T> next){
            this.val = val;
            this.next = next;
        }
    }

    public static <T> Node<T> buildList(Iterator<String> itr, Function<String, T> f){
        return buildList(itr, f, "recursive");
    }


    public static <T> Node<T> buildList(Iterator<String> itr, Function<String, T> f, String type){
        switch (type){
            case "iterative" : return buildListIterative(itr, f);
            default: return buildListRecursive(itr, f);
        }
    }


    public static <T> Node<T> buildListIterative(Iterator<String> itr, Function<String, T> f){
        T val = f.apply(itr.next());
        Node<T> root = new Node<>(val, null);
        Node<T> current = root;
        while(itr.hasNext()){
            current.next = new Node<T>(f.apply(itr.next()), null);
            current = current.next;
        }
        return root;
    }

    public static <T> Node<T> buildListRecursive(Iterator<String> itr, Function<String, T> f){
        if(!itr.hasNext()) return null;
        Node<T> node = new Node<>(f.apply(itr.next()),null);
        node.next = buildListRecursive(itr, f);
        return node;
    }


    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> fast = head, slow = head;
        int index = 0;
        while(fast != null){
            fast = fast.next;
            if(index > 1 && index % 2 == 1) slow = slow.next;
            index++;
        }
        return slow.val;
    }

}
