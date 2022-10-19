package com.connor.backtracking;

import java.util.List;

public class Node<T> {
    public List<Node<T>> children;
    public T val;
    public Node(T val){
        this(val, null);
    }
    public Node(T val, List<Node<T>> children){
        this.val = val;
        this.children = children;
    }
}
